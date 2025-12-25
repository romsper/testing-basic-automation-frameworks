package backend.api.endpoints

import backend.api.models.LoginRequest
import backend.api.models.LoginResponse
import backend.api.models.RefreshRequest
import feign.Headers
import feign.RequestLine

interface AuthEndpoints {

    @RequestLine("POST auth/login")
    @Headers("Content-Type: application/json")
    fun postLogin(body: LoginRequest) : LoginResponse

    @RequestLine("POST auth/refresh")
    @Headers("Content-Type: application/json")
    fun postRefresh(body: RefreshRequest) : LoginResponse
}