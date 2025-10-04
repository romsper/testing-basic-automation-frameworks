package frontend.elements

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class HeaderElements {
    private val listLinks get() = elements(byDataTestGroup("nav-link"))
    private val numberOfProductsInCart get() = element(byDataTestId("nav-link-cart-count"))

    @Step("Click on header link: {name}")
    fun clickHeaderLink(name: String): HeaderElements {
        listLinks.first { it.text == name }.click()
        return this
    }

//    @Step("Get number of products in cart")
    fun getNumberOfProductsInCart(): Int {
        return numberOfProductsInCart.text.toInt()
    }
}