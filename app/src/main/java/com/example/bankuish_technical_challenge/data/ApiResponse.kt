package com.example.bankuish_technical_challenge.data


sealed class ApiResponse<T>(open val data: T? = null, open val message: String? = null) {
    class Success<T>(override val data: T) : ApiResponse<T>()
    class Error<T>(override val message: String?) : ApiResponse<T>()
}