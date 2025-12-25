package backend.api.endpoints

import backend.api.client.FeignClient
import backend.helpers.Properties.Companion.properties

open class Endpoints {
    protected val auth: AuthEndpoints get() = FeignClient.get.target(AuthEndpoints::class.java, properties.backendUrl)
}