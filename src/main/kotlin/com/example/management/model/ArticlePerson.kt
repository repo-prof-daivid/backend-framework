package com.example.management.model

import org.springframework.data.repository.cdi.Eager
import javax.persistence.*
@Eager
@Entity
data class ArticlePerson(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @OneToOne(targetEntity = Person::class)
    val person: Person,

    @OneToOne(targetEntity = Article::class)
    val article: Article,

)