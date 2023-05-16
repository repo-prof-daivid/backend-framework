package com.example.management.controller

import com.example.management.model.entity.Funcionario
import com.example.management.model.entity.Gerente
import com.example.management.repository.FuncionarioRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class FuncionarioController(
    private val funcionarioRepository: FuncionarioRepository
) {
    @GetMapping("/funcionarios/{matriculaGerente}")
    fun listFuncionarios(
        @PathVariable(value = "matriculaGerente") matriculaGerente: Long
    ) : ResponseEntity<List<Funcionario>> {
        val gerente = Gerente(matricula =  matriculaGerente)
        val funcionarios = funcionarioRepository.findByGerente(gerente)
        return funcionarios?.let {
            ResponseEntity.ok(funcionarios)
        } ?: run {
            ResponseEntity.notFound().build()
        }
    }
}