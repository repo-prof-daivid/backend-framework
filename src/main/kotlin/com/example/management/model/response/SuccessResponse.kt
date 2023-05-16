package com.example.management.model.response

data class SuccessResponse<T>(
    val message: String,
    val data: T
)
