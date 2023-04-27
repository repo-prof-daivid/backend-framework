package com.example.management.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Person(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @get: NotBlank
    val name: String,
)