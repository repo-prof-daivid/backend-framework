package com.example.management.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Tarefa(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @get: NotBlank
    val titulo: String,
    @get: NotBlank
    val descricao: String,
    @get: NotBlank
    val status: String,
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="gerenteId")
    val gerente: Gerente,
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="funcionarioId")
    val funcionario: Gerente
)