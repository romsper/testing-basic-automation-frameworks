package kotlinExamples

import org.junit.jupiter.api.Test

class StreamAPI {

    @Test
    fun streamAPIExamples() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // Найти все четные числа, умножить их на 2 и взять первые три
        val result = numbers.filter { it % 2 == 0 }  // { 2, 4, 6 }
            .map { it * 2 }                          // { 4, 8, 12 }
            .take(3)                             // { 4, 8, 12 }
            .toList()

        println(result) // Выведет [4, 8, 12]
    }

    // Java

    /*
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    // Та же логика с использованием Stream API
    List<Integer> result = numbers.stream()
        .filter(n -> n % 2 == 0)                    // { 2, 4, 6 }
        .map(n -> n * 2)                            // { 4, 8, 12 }
        .limit(3)                                   // { 4, 8, 12 }
        .collect(Collectors.toList());

    System.out.println(result); // Выведет [4, 8, 12]
     */
}