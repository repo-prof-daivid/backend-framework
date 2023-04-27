package com.example.management.model

import org.springframework.context.annotation.Lazy
import org.springframework.data.repository.cdi.Eager
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.validation.constraints.NotBlank

/**
 * Created by rajeevkumarsingh on 05/10/17.
 */
@Lazy
@Entity
data class Article (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @get: NotBlank
    val title: String = "",

    @get: NotBlank
    val content: String = "",
)