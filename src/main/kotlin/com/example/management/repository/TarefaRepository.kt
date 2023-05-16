package com.example.management.repository

import com.example.management.model.entity.Tarefa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TarefaRepository : JpaRepository<Tarefa, Long>