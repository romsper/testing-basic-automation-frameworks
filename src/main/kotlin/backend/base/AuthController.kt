package backend.base

import backend.api.endpoints.Endpoints
import backend.api.models.LoginRequest
import backend.api.models.LoginResponse
import backend.api.models.RefreshRequest
import io.qameta.allure.Step

class AuthController: Endpoints() {

    @Step("Login: {email} | {password}")
    fun login(email: String, password: String): LoginResponse {
        return auth.postLogin(body = LoginRequest(email = email, password = password))
    }

    @Step("Refresh Token: {refreshToken)")
    fun refreshToken(refreshToken: String?): LoginResponse {
        return auth.postRefresh(body = RefreshRequest(refreshToken = refreshToken))
    }
}