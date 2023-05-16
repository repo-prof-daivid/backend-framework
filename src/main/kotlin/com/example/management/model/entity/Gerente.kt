package com.example.management.model.entity

import org.hibernate.annotations.Fetch
import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Gerente(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val matricula: Long = 0,
    @get: NotBlank
    val nome: String? = null,
    @get: NotBlank
    val setor: String? = null,
    @get: NotBlank
    val telefone: String? = null,
    @get: NotBlank
    val email: String? = null,
    @get: NotBlank
    val pwd: String? = null
)
