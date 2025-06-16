import kotlinx.coroutines.*
import java.io.File
import java.util.concurrent.atomic.AtomicInteger

fun main() = runBlocking{

        val file = File("example2.txt")
        file.createNewFile()

    val number = AtomicInteger(2)

    val job = launch (Dispatchers.IO){
        while (number.get() <= 90){
            file.appendText(number.get().toString() + " ")
            delay(50)
            number.addAndGet(1)
        }
    }

    while (number.get() <= 90){
        print("$number \t")
        delay(50)
    }

    job.join()
}