package com.example.management.controller

import com.example.management.model.entity.Gerente
import com.example.management.model.entity.Tarefa
import com.example.management.model.response.BaseResponse
import com.example.management.repository.FuncionarioRepository
import com.example.management.repository.GerenteRepository
import com.example.management.repository.TarefaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TarefaController(
    private val tarefaRepository: TarefaRepository,
    private val gerenteRepository: GerenteRepository,
    private val funcionarioRepository: FuncionarioRepository
) {
    @GetMapping("/tarefas/{matriculaGerente}")
    fun listTarefas(
        @PathVariable(value = "matriculaGerente") matriculaGerente: Long
    ) : ResponseEntity<BaseResponse<List<Tarefa>?>> {
        val gerente = Gerente(matricula =  matriculaGerente)
        val tarefas = tarefaRepository.findByGerente(gerente)
        return tarefas?.let { tarefas ->
            BaseResponse.createResponse(
                isError = false,
                code = HttpStatus.OK,
                data = tarefas
            )
        } ?: run {
            BaseResponse.createResponse(
                isError = true,
                message = "Falha na requisição, por favor tente mais tarde!",
                code = HttpStatus.NOT_FOUND,
            )
        }
    }

    @PostMapping("/createTarefa/{matriculaGerente}")
    fun createTarefa(
        @PathVariable(value = "matriculaGerente") matriculaGerente: Long,
        @Valid @RequestBody tarefa: Tarefa
    ) : Tarefa {
        val gerente = Gerente(matricula = matriculaGerente)
        tarefa.gerente = gerente
        return tarefaRepository.save(tarefa)
    }

    @PutMapping("/updateTarefa")
    fun updateTarefa(
        @Valid @RequestBody newTarefa: Tarefa
    ) : ResponseEntity<Tarefa> {
        return tarefaRepository.findById(newTarefa.id).map { existingTarefa ->
            val updatedTarefa: Tarefa = existingTarefa
                .copy(
                    titulo = newTarefa.titulo,
                    descricao = newTarefa.descricao,
                    status = newTarefa.status,
                    funcionario = newTarefa.funcionario
                )
            ResponseEntity.ok().body(tarefaRepository.save(updatedTarefa))
        }.orElse(ResponseEntity.notFound().build())
    }
}