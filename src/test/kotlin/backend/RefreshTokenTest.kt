package backend

import backend.api.client.ApiException
import backend.api.models.errorInvalidRefreshToken
import backend.base.Controllers
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Authorization")
@Story("Refresh Token")
@Tags(Tag("auth"), Tag("backend"), Tag("regress"))
class RefreshTokenTest : Controllers {

    @Test
    @DisplayName("User can refresh token with valid refresh token")
    fun testUserCanRefreshToken() {
        val loginResponse = auth.login(email = "random@test.com", password = "random")
        val refreshResponse = auth.refreshToken(refreshToken = loginResponse.refreshToken)

        refreshResponse.accessToken shouldNotBe loginResponse.accessToken
        refreshResponse.refreshToken shouldNotBe loginResponse.refreshToken
    }

    @Test
    @DisplayName("User cannot refresh token with invalid refresh token")
    fun testUserCannotRefreshTokenWithInvalidRefreshToken() {
        val exception = shouldThrow<ApiException> { auth.refreshToken(refreshToken = "") }

        exception.error shouldBeEqualToComparingFields errorInvalidRefreshToken
    }

    @Test
    @DisplayName("User cannot refresh token with null refresh token")
    fun testUserCannotRefreshTokenWithNullRefreshToken() {
        val exception = shouldThrow<ApiException> { auth.refreshToken(refreshToken = null) }

        exception.status shouldBe 400
    }
}