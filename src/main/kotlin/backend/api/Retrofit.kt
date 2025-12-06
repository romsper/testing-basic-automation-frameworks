package backend.api

import io.qameta.allure.okhttp3.AllureOkHttp3
import backend.helpers.Properties.Companion.properties
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.time.Duration

object RetrofitClient {

    private val timeout = Duration.ofSeconds(10)
    private val client = OkHttpClient.Builder()
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

    val kotlinSerialization = Json { ignoreUnknownKeys = false }
    fun <T> createService(service: Class<T>): T =
        Retrofit.Builder()
            .baseUrl(properties.backendUrl)
            .client(client)
            .addConverterFactory(kotlinSerialization.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(service)
}