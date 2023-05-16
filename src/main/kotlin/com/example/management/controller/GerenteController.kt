package com.example.management.controller

import com.example.management.model.entity.Gerente
import com.example.management.model.request.Login
import com.example.management.model.response.BaseResponse
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

    @PostMapping("/login")
    fun login(@Valid @RequestBody login: Login): ResponseEntity<BaseResponse<Gerente?>> {
        val gerente = login.email?.let {
            gerenteRepository.findByEmail(it)
        } ?: run {
            login.matricula?.let {
                this.getGerenteById(login.matricula).body
            }
        }
        gerente?.let { gerente ->
            if (login.pwd == gerente.pwd) {
                return BaseResponse.createResponse(
                    isError = false,
                    data = gerente,
                    code = HttpStatus.OK
                )
            } else {
                return BaseResponse.createResponse()
            }
        } ?: run {
            return BaseResponse.createResponse()
        }
    }



}