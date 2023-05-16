package com.example.management.controller

import com.example.management.model.entity.Funcionario
import com.example.management.model.entity.Gerente
import com.example.management.model.response.BaseResponse
import com.example.management.repository.FuncionarioRepository
import org.springframework.http.HttpStatus
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
    ) : ResponseEntity<BaseResponse<List<Funcionario>?>> {
        val gerente = Gerente(matricula =  matriculaGerente)
        val funcionarios = funcionarioRepository.findByGerente(gerente)
        return funcionarios?.let { funcionarios ->
            BaseResponse.createResponse(
                isError = false,
                data = funcionarios,
                code = HttpStatus.OK
            )
        } ?: run {
            BaseResponse.createResponse(
                isError = true,
                data = null,
                message = "Falha na requisição, por favor tente mais tarde!",
                code = HttpStatus.NOT_FOUND
            )
        }
    }
}