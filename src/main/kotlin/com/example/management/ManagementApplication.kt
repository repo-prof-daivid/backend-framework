package com.example.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ManagementApplication

fun main(args: Array<String>) {
    runApplication<ManagementApplication>(*args)
}
