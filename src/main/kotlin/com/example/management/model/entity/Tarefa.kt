package com.example.management.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY, targetEntity = Gerente::class)
    @JoinColumn(name="gerenteId")
    var gerente: Gerente? = null,
    @ManyToOne(fetch=FetchType.LAZY, targetEntity = Funcionario::class)
    @JoinColumn(name="funcionarioId")
    var funcionario: Funcionario? = null
)