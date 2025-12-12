package kotlinExamples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class Coroutines {

    @Test
    fun coroutineExamples() {
        runBlocking { // Запускает основную корутину
            println("Start")

            // Запускаем новую корутину, не блокируя основной поток
            launch {
                delay(1000L) // Неблокирующая задержка на 1 секунду
                println("World!")
            }

            print("Hello, ")
            delay(2000L) // Ждем завершения
            println("Done")
        }

        runBlocking {
            println("Start")

            val job = launch {
                delay(1000L)
                println("World!")
            }

            print("Hello, ")
            job.join() // Блокируем до завершения job
            println("Done")
        }
    }

    // Java

    /*
    // Вывод будет похожим, но управление потоками вручную сложнее и затратнее.
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        // Создаем и запускаем новый поток
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L); // Блокирующая задержка
                System.out.println("World!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        System.out.print("Hello, ");
        thread.join(); // Ждем завершения потока
        System.out.println("Done");
    }
     */
}