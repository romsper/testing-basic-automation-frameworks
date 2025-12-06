package backend

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.extension.Extensions.Companion.getErrorAsObject
import backend.api.models.ErrorResponse
import backend.api.models.errorInvalidCredentials
import backend.base.Controllers
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
        val response = auth.login(email = "random@test.com", password = "random").getAsObject()

        response.accessToken.length shouldBeGreaterThan 10
        response.refreshToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("User cannot log in with invalid credentials")
    fun testUserCannotLoginWithInvalidCredentials() {
        val response = auth.login(email = "lol", password = "kek").getErrorAsObject<ErrorResponse>()

        response shouldBeEqualToComparingFields errorInvalidCredentials
    }

    @Test
    @DisplayName("User cannot log in with empty credentials")
    fun testUserCannotLoginWithEmptyCredentials() {
        val response = auth.login(email = "", password = "").getErrorAsObject<ErrorResponse>()

        response shouldBeEqualToComparingFields errorInvalidCredentials
    }
}