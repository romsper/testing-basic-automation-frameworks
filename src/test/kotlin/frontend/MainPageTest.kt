package frontend

import frontend.helpers.BaseTest
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import io.qameta.allure.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Main page")
@Story("Image")
@Tags(Tag("main"), Tag("regress"))
class MainPageTest : BaseTest() {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check main page title")
    fun checkTitleText() {
        val title = MainPage()
            .open()
            .getTitleText()

        title shouldBe "Welcome to Brew & Bean"
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check four popular products is displayed")
    fun checkPopularProducts() {
        val products = MainPage()
            .open()
            .getPopularProducts()

        products.size shouldBe 4
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Check quantity and cart numbers after adding product from popular")
    fun addProductToCartFromPopular() {
        MainPage()
            .open()
            .getPopularProducts()
            .first()
            .btnIncrement
            .click()

        val firstProductQuantity = MainPage()
            .getPopularProducts()
            .first()
            .quantity

        val numberOfProductsInCart = MainPage()
            .navigateHeader()
            .getNumberOfProductsInCart()

        firstProductQuantity shouldBe 1
        numberOfProductsInCart shouldBe 1
    }
}