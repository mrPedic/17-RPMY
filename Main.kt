import kotlinx.coroutines.*
import java.io.File

fun main() = runBlocking{

    var file = File("example1.txt")
    if (!file.exists()) {
        println("Не найден файл с массивом, будет создан запасной массив")

        file = File("example1.txt")
        file.createNewFile()
        file.writeText("1 2 3 0 4 5 6 0 7 8 9")
    }

    val job = launch (Dispatchers.IO){
        val mass = file.readText().split(" ").toMutableList()
        println("Массив полученный из файла : $mass")

        var lastZero: Int
        var sum = 0

        for (el in mass){
            if ( el.toInt() == 0 )
                sum = 0
            sum += el.toInt()
        }
        println("Сумму элементов массива, расположенных после последнего элемента равна : $sum")
    }

    job.join()
}