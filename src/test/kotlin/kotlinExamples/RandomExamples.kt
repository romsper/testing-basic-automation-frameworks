package kotlinExamples

import org.junit.jupiter.api.Test

class RandomExamples {

    @Test
    fun whenExamples() {
        println("// --- When examples --- //")

        println("День недели: ${getDayType(2)}") // Выведет "Weekday"
        println("День недели: ${getDayType(7)}") // Выведет "Weekend"

        // Пример с проверкой типа

        val x: Any = "Hello"
        when (x) {
            is String -> println("Строка с количеством символов: ${x.length}")
            is Int -> println("Это число: $x")
            else -> println("Неизвестный тип")
        }

        // Пример с диапазонами

        val number = 15
        when (number) {
            in 1..10 -> println("Число от 1 до 10")
            in 11..20 -> println("Число от 11 до 20")
            else -> println("Число вне диапазона 1-20")
        }

        // Пример без аргумента

        val a = 5
        val b = 10
        when {
            a > b -> println("a больше b")
            a < b -> println("a меньше b")
            else -> println("a равно b")
        }

        println("// --- End --- //")
    }

    @Test
    fun forExamples() {
        println("// --- For examples --- //")

        val numbers = listOf(1, 2, 3, 4, 5)

        // Простой цикл for
        for (num in numbers) {
            println(num)
        }

        // Цикл с индексами
        for ((index, value) in numbers.withIndex()) {
            println("Индекс: $index, Значение: $value")
        }

        // Цикл по диапазону
        for (i in 1..5) {
            println(i)
        }

        // Цикл с шагом
        for (i in 1..10 step 2) {
            println(i)
        }

        // Цикл в обратном порядке
        for (i in 5 downTo 1) {
            println(i)
        }

        val items = listOf("apple", "banana", "cherry")

        // Простая итерация по списку
        items.forEach { item ->
            println("Fruit: $item")
        }

        // Если лямбда принимает один аргумент, можно использовать 'it'
        items.forEach {
            println("I love $it!")
        }

        println("// --- End --- //")
    }

    @Test
    fun ifExamples() {
        println("// --- If examples --- //")

        val a = 10
        val b = 20

        // Результат 'if-else' напрямую присваивается переменной 'max'
        val max = if (a > b) {
            println("Переменная: a") // Это тоже выполнится
            a
        } else {
            println("Переменная: b")
            b
        }

        println("Макс $max") // 20

        // Тоже самое но с .also (второй вариант)
        val newMax = if (a > b) a.also { println("Переменная: a") } else b.also { println("Переменная: b") }
        println("Макс $newMax") // 20

        println("// --- End --- //")
    }
}

fun getDayType(dayOfWeek: Int) = when (dayOfWeek) {
    1, 2, 3, 4, 5 -> "Weekday"
    6, 7 -> "Weekend"
    else -> "В недели только 7 дней и начинается с 1"
}

// Java

/*
public String getDayType(int dayOfWeek) {
    String dayType;
    switch (dayOfWeek) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            dayType = "Weekday";
            break;
        case 6:
        case 7:
            dayType = "Weekend";
            break;
        default:
            dayType = "Invalid day";
            break;
    }
    return dayType;
}

// Пример использования
System.out.println(getDayType(2)); // Выведет "Weekday"
System.out.println(getDayType(7)); // Выведет "Weekend"
 */