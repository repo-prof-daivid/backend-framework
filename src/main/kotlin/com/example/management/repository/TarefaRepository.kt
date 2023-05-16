package com.example.management.repository

import com.example.management.model.entity.Funcionario
import com.example.management.model.entity.Gerente
import com.example.management.model.entity.Tarefa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TarefaRepository : JpaRepository<Tarefa, Long>{
    fun findByGerente(gerente: Gerente): List<Tarefa>?

}