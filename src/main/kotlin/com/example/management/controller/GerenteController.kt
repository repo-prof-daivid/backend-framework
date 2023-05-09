package com.example.management.controller

import com.example.management.model.Gerente
import com.example.management.repository.GerenteRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class GerenteController(
    private val gerenteRepository: GerenteRepository
) {

    @GetMapping("/gerentes")
    fun getGerentes(): List<Gerente> =
        gerenteRepository.findAll()


    @PostMapping("/gerente")
    fun createNewGerente(@Valid @RequestBody gerente: Gerente): Gerente =
        gerenteRepository.save(gerente)


    @GetMapping("/gerente/{matriculaGerente}")
    fun getGerenteById(@PathVariable(value = "matriculaGerente") matriculaGerente: Long):
            ResponseEntity<Gerente> {
        return gerenteRepository.findById(matriculaGerente).map { gerente ->
            ResponseEntity.ok(gerente)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/gerente/{matriculaGerente}")
    fun updateGerenteById(@PathVariable(value = "matriculaGerente") matriculaGerente: Long,
                          @Valid @RequestBody newGerente: Gerente): ResponseEntity<Gerente> {

        return gerenteRepository.findById(matriculaGerente).map { existingGerente ->
            val updatedGerente: Gerente = existingGerente
                    .copy(
                        name = newGerente.name,
                        pwd = newGerente.pwd,
                        email = newGerente.email,
                        telefone = newGerente.telefone,
                        setor = newGerente.setor,
                        funcionarios = newGerente.funcionarios,
                        tarefas = newGerente.tarefas
                    )
            ResponseEntity.ok().body(gerenteRepository.save(updatedGerente))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/gerente/{matriculaGerente}")
    fun deleteArticleById(@PathVariable(value = "matriculaGerente") matriculaGerente: Long): ResponseEntity<Void> {

        return gerenteRepository.findById(matriculaGerente).map { gerente  ->
            gerenteRepository.delete(gerente)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

}