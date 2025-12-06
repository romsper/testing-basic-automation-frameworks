package backend.api.endpoints

import backend.api.models.LoginRequest
import backend.api.models.LoginResponse
import backend.api.models.RefreshRequest
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthEndpoints {

    @POST("auth/login")
    fun postLogin(@Body body: LoginRequest) : Call<LoginResponse>

    @POST("auth/refresh")
    fun postRefresh(@Body body: RefreshRequest) : Call<LoginResponse>
}