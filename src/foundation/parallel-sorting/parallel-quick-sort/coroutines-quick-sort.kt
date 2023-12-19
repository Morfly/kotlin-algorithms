package foundation.`parallel-sorting`.`parallel-quick-sort`.coroutines

import foundation.sorting.`insertion-sort`.range.insertionSort
import foundation.sorting.`quick-sort`.partition.hoarePartition
import foundation.sorting.`quick-sort`.quickSort
import io.morfly.algorithms.tools.isSorted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

private const val THRESHOLD = 100

suspend fun IntArray.parallelQuickSort() {
    shuffle()
    parallelQuickSort(start = 0, end = size)
}

suspend fun IntArray.parallelQuickSort(start: Int, end: Int) {
    if (end - start < THRESHOLD) {
        insertionSort(start, end)
        return
    }
    val pivot = hoarePartition(start, end)

    coroutineScope {
        val left = launch(Dispatchers.Default) { parallelQuickSort(start, pivot) }
        val right = launch(Dispatchers.Default) { parallelQuickSort(pivot + 1, end) }
        left.join()
        right.join()
    }
}


fun main() = runBlocking {
    // Parallel sort
    val array1 = IntArray(200_000_000) { Random.nextInt(1, Int.MAX_VALUE) }
    val time1 = measureTimeMillis {
        array1.parallelQuickSort()
    }
    println("Parallel sort: $time1")
    require(array1.isSorted())

    // Sequential sort
    val array2 = IntArray(200_000_000) { Random.nextInt(1, Int.MAX_VALUE) }
    val time2 = measureTimeMillis {
        array2.quickSort()
    }
    println("Sequential sort: $time2")
    require(array2.isSorted())
}