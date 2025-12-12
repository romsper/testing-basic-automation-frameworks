package kotlinExamples

import org.junit.jupiter.api.Test

class ExtensionFunctions {

    @Test
    fun extensionFunctionExamples() {
        // Добавляем новую функцию 'addExclamation' к классу String
        fun String.addExclamation(): String {
            return "$this!"
        }

        val greeting = "Hello"

        // Вызываем новую функцию как будто она была в классе String
        println(greeting.addExclamation()) // Выведет "Hello!"
    }

    // Java

    /*
    // В Java нет прямого аналога. Обычно создают статические утилитные методы.
    class StringUtils {
        public static String addExclamation(String s) {
            return s + "!";
        }
    }

    String greeting = "Hello";
    // Вызов выглядит менее элегантно
    System.out.println(StringUtils.addExclamation(greeting)); // Выведет "Hello!"
     */
}
