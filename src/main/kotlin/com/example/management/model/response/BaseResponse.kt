package com.example.management.model.response

data class BaseResponse<T>(
    val isError: Boolean,
    val errorMessage: String? = null,
    val data: T? = null,
    val code: Int
)
