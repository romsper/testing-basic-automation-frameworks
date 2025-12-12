package database

import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class ExposedClient {
    private val jdbcUrl = "jdbc:postgresql://localhost:5432/playground"
    private val username: String = "postgres"
    private val password: String = "postgres"

    fun getAllProducts(): List<Product> {
        val db = Database.connect(
            url = jdbcUrl,
            driver = "org.postgresql.Driver",
            user = username,
            password = password
        )

        return transaction(db) {
            ProductEntity
                .selectAll()
                .map { ProductEntity.toModel(it) }
        }.also { db.connector().close() }
    }
}