package kotlinExamples

import org.junit.jupiter.api.Test

class NullSafety {

    @Test
    fun nullSafetyExamples() {
        // Эта переменная не может быть null
        var nonNullable: String = "Hello"
        // nonNullable = null // Ошибка компиляции!

        // Чтобы разрешить null, нужно добавить '?'
        var nullable: String? = "World"
        nullable = null // OK

        // Безопасный вызов метода
        println(nullable?.length) // Выведет null, если nullable == null

        // Проверка на null
        // if (nullable != null) {
        //     println(nullable.length) // Компилятор "умно" приводит тип
        // }
    }

    // Java

    /*
    // Любая объектная переменная может быть null
    String possiblyNull = "World";
    possiblyNull = null; // OK

    // Это может привести к NullPointerException во время выполнения
    try {
        System.out.println(possiblyNull.length());
    } catch (NullPointerException e) {
        System.out.println("Oops, NullPointerException!");
    }

    // Ручная проверка на null
    if (possiblyNull != null) {
        System.out.println(possiblyNull.length());
    }
     */
}