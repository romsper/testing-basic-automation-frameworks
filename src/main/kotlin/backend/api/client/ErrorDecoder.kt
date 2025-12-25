package backend.api.client

import backend.api.models.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.ErrorDecoder

class ErrorDecoder(val mapper: ObjectMapper) : ErrorDecoder {
    private val defaultStatus = -1

    override fun decode(methodKey: String?, response: Response?): Exception {
        return try {
            val status = response?.status() ?: defaultStatus
            val reason = response?.reason()

            when (status) {
                in 400..599 -> {
                    val errorResponse = response?.body()?.asInputStream()?.use { stream ->
                        mapper.readValue(stream, ErrorResponse::class.java)
                    } ?: ErrorResponse(defaultStatus, "Error body is null")

                    ApiException(status, "Exception: code:$status | message:$reason", errorResponse)
                }
                else -> ApiException(status, "Exception: code:$status | message:$reason", ErrorResponse(defaultStatus, "Unexpected status code") )
            }
        } catch (e: Exception) {
            ApiException(defaultStatus, "Exception during error decoding: ${e.message}", ErrorResponse(defaultStatus, "Unknown error"))
        }
    }
}

class ApiException(code: Int, message: String, errorResponse: ErrorResponse) : RuntimeException(message) {
    val status: Int = code
    val error: ErrorResponse = errorResponse
}
