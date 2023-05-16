package com.example.management.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Gerente(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val matricula: Long = 0,
    @get: NotBlank
    val name: String,
    @get: NotBlank
    val setor: String,
    @get: NotBlank
    val telefone: String,
    @get: NotBlank
    val email: String,
    @get: NotBlank
    val pwd: String
)
