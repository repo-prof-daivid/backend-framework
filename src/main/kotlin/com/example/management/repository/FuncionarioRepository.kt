package com.example.management.repository

import com.example.management.model.entity.Funcionario
import com.example.management.model.entity.Gerente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : JpaRepository<Funcionario, Long>{
    fun findByGerente(gerente: Gerente): List<Funcionario>?
}