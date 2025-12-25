package database

import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float,
)

object ProductEntity : IntIdTable("table_products") {
    var Name = varchar("name", 100)
    var Description = varchar("description", 255)
    var Price = float("price")
}

fun ProductEntity.toModel(resultRow: ResultRow) = Product(
    id = resultRow[id].value,
    name = resultRow[Name],
    description = resultRow[Description],
    price = resultRow[Price]
)
