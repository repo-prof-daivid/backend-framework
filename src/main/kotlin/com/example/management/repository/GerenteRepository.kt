package com.example.management.repository

import com.example.management.model.request.Gerente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GerenteRepository : JpaRepository<Gerente, Long>{
    fun findByEmail(email: String): Gerente?
}