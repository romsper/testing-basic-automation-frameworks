package backend.api.models

data class LoginRequest(
    val email: String?,
    val password: String?
)

data class LoginResponse(
    val accessToken: String,
    val createdAt: Long,
    val expireInMs: Long,
    val id: Int,
    val refreshToken: String
)

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