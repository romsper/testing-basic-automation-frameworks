package backend

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.extension.Extensions.Companion.getErrorAsObject
import backend.api.models.ErrorResponse
import backend.api.models.errorInvalidRefreshToken
import backend.base.Controllers
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
        val loginResponse = auth.login(email = "random@test.com", password = "random").getAsObject()
        val refreshResponse = auth.refreshToken(refreshToken = loginResponse.refreshToken).getAsObject()

        refreshResponse.accessToken shouldNotBe loginResponse.accessToken
        refreshResponse.refreshToken shouldNotBe loginResponse.refreshToken
    }

    @Test
    @DisplayName("User cannot refresh token with invalid refresh token")
    fun testUserCannotRefreshTokenWithInvalidRefreshToken() {
        val response = auth.refreshToken(refreshToken = "").getErrorAsObject<ErrorResponse>()

        response shouldBeEqualToComparingFields errorInvalidRefreshToken
    }

    @Test
    @DisplayName("User cannot refresh token with null refresh token")
    fun testUserCannotRefreshTokenWithNullRefreshToken() {
        val response = auth.refreshToken(refreshToken = null)

        response.code() shouldBe 400
    }
}