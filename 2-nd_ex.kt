import kotlinx.coroutines.*
import java.io.File
import java.util.concurrent.atomic.AtomicInteger

fun main() = runBlocking{

        val file = File("example2.txt")
        file.createNewFile()

    val number = AtomicInteger(2)

    val job = launch (Dispatchers.IO){
        while (number.get() <= 90){
            file.appendText("$number\t" )
            plusNumber(number)
        }
    }
    job.join()
}

fun plusNumber (number: AtomicInteger): AtomicInteger{
    print("${number}\t")
    number.addAndGet(1)
    return number
}
