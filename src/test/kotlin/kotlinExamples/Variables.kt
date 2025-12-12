package kotlinExamples

import org.junit.jupiter.api.Test

class Variables {

    private var lolKek: String? = null

    @Test
    fun variableExamples() {
        // Неизменяемая переменная
        val immutableString: String = "Hello"
        // immutableString = "World" // Ошибка компиляции

        // Изменяемая переменная
        var mutableInt: Int = 10
        mutableInt = 20 // OK

        // Тип можно не указывать явно, он будет выведен компилятором
        val inferredType = "Тип String"
    }

    // Java

    /*
    // Неизменяемая переменная
    final String immutableString = "Hello";

    // Изменяемая переменная
    int mutableInt = 10;
    mutableInt = 20; // OK

    // Тип нужно всегда указывать явно
    String inferredType = "Тип String";
     */
}