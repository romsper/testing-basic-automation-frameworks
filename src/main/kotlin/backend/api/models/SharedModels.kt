package backend.api.models

data class ErrorResponse(
    val code: Int,
    val reason: String
)