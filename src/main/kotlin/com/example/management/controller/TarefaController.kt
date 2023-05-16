package com.example.management.controller

import com.example.management.model.entity.Gerente
import com.example.management.model.entity.Tarefa
import com.example.management.repository.TarefaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TarefaController(
    private val tarefaRepository: TarefaRepository
) {
    @GetMapping("/tarefas/{matriculaGerente}")
    fun listTarefas(
        @PathVariable(value = "matriculaGerente") matriculaGerente: Long
    ) : ResponseEntity<List<Tarefa>> {
        val gerente = Gerente(matricula =  matriculaGerente)
        val tarefas = tarefaRepository.findByGerente(gerente)
        return tarefas?.let {
            ResponseEntity.ok(tarefas)
        } ?: run {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/createTarefa/{matriculaGerente}")
    fun createTarefa(
        @PathVariable(value = "matriculaGerente") matriculaGerente: Long,
        @Valid @RequestBody tarefa: Tarefa
    ) : Tarefa {
        val gerente = Gerente(matricula =  matriculaGerente)
        tarefa.gerente = gerente
        return tarefaRepository.save(tarefa)
    }
}