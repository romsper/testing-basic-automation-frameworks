package backend.base

import backend.api.endpoints.Endpoints
import backend.api.models.LoginRequest
import backend.api.models.LoginResponse
import backend.api.models.RefreshRequest
import io.qameta.allure.Step
import retrofit2.Response

class AuthController: Endpoints() {

    @Step("Login: {email} | {password}")
    fun login(email: String, password: String): Response<LoginResponse> {
        return auth.postLogin(body = LoginRequest(email = email, password = password)).execute()
    }

    @Step("Refresh Token: {refreshToken)")
    fun refreshToken(refreshToken: String?): Response<LoginResponse> {
        return auth.postRefresh(body = RefreshRequest(refreshToken = refreshToken)).execute()
    }
}