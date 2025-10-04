package frontend.elements.list

import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTestGroup

class ProductItemsHelper {
    private val listProducts get() = elements(byDataTestGroup("product-card"))

    fun getProductItems(): List<ProductItem> {
        return listProducts
            .map {
                ProductItem(
                    image = it.find(byDataTestGroup("product-card-image")),
                    name = it.find(byDataTestGroup("product-card-name")).text,
                    description = it.find(byDataTestGroup("product-card-description")).text,
                    price = it.find(byDataTestGroup("product-card-price")).text.replace("$", "").toFloat(),
                    btnIncrement = it.find(byDataTestGroup("product-card-increment")),
                    quantity = it.find(byDataTestGroup("product-card-qty")).text.toInt(),
                    btnDecrement = it.find(byDataTestGroup("product-card-decrement")),
                )
            }
    }
}

data class ProductItem(
    val image: SelenideElement,
    val name: String,
    val description: String,
    val price: Float,
    val btnDecrement: SelenideElement,
    val quantity: Int,
    val btnIncrement: SelenideElement,
)