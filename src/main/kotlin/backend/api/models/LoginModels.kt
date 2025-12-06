package backend.api.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String?,
    val password: String?
)

@Serializable
data class LoginResponse(
    val accessToken: String,
    val createdAt: Long,
    val expireInMs: Long,
    val id: Int,
    val refreshToken: String
)

@Serializable
data class RefreshRequest(
    val refreshToken: String?
)

val errorInvalidCredentials = ErrorResponse(
    code = 400,
    reason = "Invalid email or password"
)

val errorInvalidRefreshToken = ErrorResponse(
    code = 400,
    reason = "Invalid refresh token"
)