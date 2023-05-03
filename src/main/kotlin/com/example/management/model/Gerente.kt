package com.example.management.model

import org.springframework.context.annotation.Lazy
import org.springframework.data.repository.cdi.Eager
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
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
    val pwd: String,
    @OneToMany(targetEntity = Funcionario::class)
    val funcionarios: List<Funcionario>,
    @OneToMany(targetEntity = Tarefa::class)
    val tarefas: List<Tarefa>
)
