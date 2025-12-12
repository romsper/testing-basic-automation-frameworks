package kotlinExamples

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScopeFunctions {

    @Test
    fun scopeFunctionExamples() {
        data class Person(var name: String, var age: Int)

        val person = Person("Alice", 25)

        // 'let' используется для выполнения блока кода с объектом как аргументом
        val nameLength = person.name.let {
            println("Имя: $it")
            it.length // Возвращаем длину имени
        }.let {  }.let {  }
        println("Длина имени: $nameLength")

        // 'apply' используется для инициализации объекта
        val updatedPerson = person.apply {
            age += 1 // Увеличиваем возраст на 1
            name = "Alice Smith" // Обновляем имя
        }
        println("Обновленная персона: $updatedPerson")

        // 'also' используется для выполнения дополнительных действий с объектом
        val loggedPerson = person.also {
            println("Авторизация: $it")
        }
        println("Залогиненый пользователь: $loggedPerson")
    }

    // Java

    /*
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + '}';
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 25);

        // 'let' эквивалент: отсутствует, используем обычный метод
        int nameLength = person.name.length();
        System.out.println("Имя: " + person.name);
        System.out.println("Длина имени: " + nameLength);

        // 'apply' эквивалент: отсутствует, используем обычный метод
        person.age += 1;
        person.name = "Alice Smith";
        Person updatedPerson = person;
        System.out.println("Обновленная персона: " + updatedPerson);

        // 'also' эквивалент: отстствует, используем обычный метод
        System.out.println("Авторизация: " + person);
        Person loggedPerson = person;
        System.out.println("Залогиненый пользователь: " + loggedPerson);
    }
     */
}