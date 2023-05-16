package com.example.management.controller

import com.example.management.model.entity.Gerente
import com.example.management.model.request.Login
import com.example.management.model.response.ErrorResponse
import com.example.management.model.response.SuccessResponse
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
    fun updateGerenteById(
        @PathVariable(value = "matriculaGerente") matriculaGerente: Long,
        @Valid @RequestBody newGerente: Gerente
    ): ResponseEntity<Gerente> {
        return gerenteRepository.findById(matriculaGerente).map { existingGerente ->
            val updatedGerente: Gerente = existingGerente
                .copy(
                    nome = newGerente.nome,
                    pwd = newGerente.pwd,
                    email = newGerente.email,
                    telefone = newGerente.telefone,
                    setor = newGerente.setor
                )
            ResponseEntity.ok().body(gerenteRepository.save(updatedGerente))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/gerente/{matriculaGerente}")
    fun deleteArticleById(@PathVariable(value = "matriculaGerente") matriculaGerente: Long): ResponseEntity<Void> {
        return gerenteRepository.findById(matriculaGerente).map { gerente ->
            gerenteRepository.delete(gerente)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody login: Login): ResponseEntity<Any> {
        val gerente = login.email?.let {
            gerenteRepository.findByEmail(it)
        } ?: run {
            login.matricula?.let {
                this.getGerenteById(login.matricula).body
            }
        }
        gerente?.let { gerente ->
            if (login.pwd == gerente.pwd) {
                return createSuccessResponse(data = gerente)
            } else {
                return createErrorResponse()
            }
        } ?: run {
            return createErrorResponse()
        }
    }

    private fun createErrorResponse(
        message: String = "Credenciais Inválidas!",
        code: HttpStatus = HttpStatus.UNAUTHORIZED
    ): ResponseEntity<Any> {
        return ResponseEntity.status(code)
            .body(
                ErrorResponse(
                    errorMessage = message,
                    errorCode = code.value()
                )
            )
    }

    private fun <T> createSuccessResponse(
        message: String = "Login realizado com sucesso!",
        data: T
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(SuccessResponse(message = message, data = data))
    }

}