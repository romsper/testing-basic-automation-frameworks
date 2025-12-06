package backend.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val code: Int,
    val reason: String
)