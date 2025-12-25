package backend.api.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import io.qameta.allure.okhttp3.AllureOkHttp3
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.time.Duration

object FeignClient {
    private val timeout = Duration.ofSeconds(10)
    private val client: OkHttpClient = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .callTimeout(timeout)
        .connectTimeout(timeout)
        .readTimeout(timeout)
        .writeTimeout(timeout)
        .addInterceptor { chain: Interceptor.Chain ->
            val builder = chain.request().newBuilder()
            chain.proceed(builder.build())
        }
        .addInterceptor(AllureOkHttp3())
        .build()


    private val jacksonMapper = jacksonObjectMapper().registerKotlinModule()
    private val jacksonDecoder = JacksonDecoder(jacksonMapper)

    val get: Feign.Builder = Feign.builder()
        .client(feign.okhttp.OkHttpClient(client))
        .decoder(jacksonDecoder)
        .errorDecoder(ErrorDecoder(jacksonMapper))
        .encoder(JacksonEncoder(jacksonMapper))
}