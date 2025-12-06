package backend.api.endpoints

import backend.api.RetrofitClient

open class Endpoints {
    protected val auth: AuthEndpoints get() = RetrofitClient.createService(AuthEndpoints::class.java)
}