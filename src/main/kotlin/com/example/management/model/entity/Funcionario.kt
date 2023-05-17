package com.example.management.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Funcionario(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val matricula: Long = 0,
    @get: NotBlank
    val nome: String? = null,
    @get: NotBlank
    val telefone: String? = null,
    @get: NotBlank
    val email: String? = null,
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gerenteId")
    val gerente: Gerente? = null
)