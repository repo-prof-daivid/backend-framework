package com.example.management.model.request

import org.springframework.context.annotation.Lazy
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
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
    @OneToMany(targetEntity = Tarefa::class)
    val tarefas: List<Tarefa>
)