package com.example.management.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Funcionario(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val matricula: Long = 0,
    @get: NotBlank
    val nome: String,
    @get: NotBlank
    val telefone: String,
    @get: NotBlank
    val email: String,
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gerenteId")
    val gerente: Gerente
)