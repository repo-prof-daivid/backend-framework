package com.example.management.repository

import com.example.management.model.Gerente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GerenteRepository : JpaRepository<Gerente, Long>