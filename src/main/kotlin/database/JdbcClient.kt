package database

import java.sql.DriverManager

class JdbcClient {

    private val jdbcUrl = "jdbc:postgresql://localhost:5432/playground"
    private val username: String = "postgres"
    private val password: String = "postgres"
    private val client = DriverManager.getConnection(jdbcUrl, username, password)

    fun getAllProducts(): List<Product> {
        val products = mutableListOf<Product>()

        try {
            val statement = client.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM table_products")

            while (resultSet.next()) {
                val product = Product(
                    id = resultSet.getInt("id"),
                    name = resultSet.getString("name"),
                    description = resultSet.getString("description"),
                    price = resultSet.getFloat("price")
                )
                products.add(product)
            }
            resultSet.close()
            statement.close()
        } catch (e: Exception) {
            println("Error fetching products: ${e.message}")
        }

        return products
    }
}