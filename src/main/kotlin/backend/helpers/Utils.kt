package backend.helpers

import io.qameta.allure.Step

class Utils {

    companion object {

//        @Step("Convert string to model")
//        inline fun <reified T> String.jsonToObject(model: Class<T>): T {
//            return RetrofitClient.kotlinSerialization.decodeFromString(this)
//        }

        @Step("Generate random alphanumeric string of given length")
        fun generateRandomString(length: Int): String {
            val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }

        @Step("Generate random email address")
        fun generateRandomEmail(): String {
            val localPart = generateRandomString(10)
            val domain = "autotest.com"
            return "$localPart@$domain"
        }
    }
}