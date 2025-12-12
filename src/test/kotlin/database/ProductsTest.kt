package database

import io.kotest.matchers.ints.shouldBeGreaterThan
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductsTest {
    // As you can see below, the Exposed ORM takes significantly longer to fetch all products compared to raw JDBC.
    // This is due to the additional abstraction and features provided by the ORM, which introduce some overhead.
    // If you have simple queries and performance is critical, using raw JDBC might be more efficient.

    // 135ms - JDBC
    @Test
    @DisplayName("Test fetching all products from the database")
    fun testGetAllProducts() {
        val jdbcClient = JdbcClient()
        val products = jdbcClient.getAllProducts()

        products.size shouldBeGreaterThan 0
    }

    // 328ms - Exposed ORM
    @Test
    @DisplayName("Test fetching all products using Exposed ORM")
    fun testGetAllProductsExposed() {
        val exposedClient = ExposedClient()
        val products = exposedClient.getAllProducts()

        products.size shouldBeGreaterThan 0
    }
}