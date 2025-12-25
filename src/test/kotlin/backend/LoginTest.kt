package backend

import backend.api.client.ApiException
import backend.api.models.errorInvalidCredentials
import backend.base.Controllers
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Authorization")
@Story("Login")
@Tags(Tag("auth"), Tag("backend"), Tag("regress"))
class LoginTest : Controllers {

    @Test
    @DisplayName("User can log in with valid credentials")
    fun testUserCanLogin() {
        val response = auth.login(email = "random@test.com", password = "random")

        response.accessToken.length shouldBeGreaterThan 10
        response.refreshToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("User cannot log in with invalid credentials")
    fun testUserCannotLoginWithInvalidCredentials() {
        val exception = shouldThrow<ApiException> { auth.login(email = "lol", password = "kek") }

        exception.error shouldBeEqualToComparingFields errorInvalidCredentials
    }

    @Test
    @DisplayName("User cannot log in with empty credentials")
    fun testUserCannotLoginWithEmptyCredentials() {
        val exception = shouldThrow<ApiException> { auth.login(email = "", password = "") }

        exception.error shouldBeEqualToComparingFields errorInvalidCredentials
    }
}