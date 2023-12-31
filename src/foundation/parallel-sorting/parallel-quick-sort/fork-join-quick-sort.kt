package foundation.`parallel-sorting`.`parallel-quick-sort`

import foundation.sorting.`insertion-sort`.range.insertionSort
import foundation.sorting.`quick-sort`.partition.hoarePartition
import foundation.sorting.`quick-sort`.quickSort
import io.morfly.algorithms.tools.isSorted
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveAction
import kotlin.random.Random
import kotlin.system.measureTimeMillis

private const val THRESHOLD = 100

fun IntArray.parallelQuickSort() {
    shuffle()
    ForkJoinPool().invoke(QuickSortTask(this, 0, this.size))
}

class QuickSortTask(
    private val arr: IntArray,
    private val start: Int,
    private val end: Int
) : RecursiveAction() {

    override fun compute() {
        if (end - start < THRESHOLD) {
            arr.insertionSort(start, end)
            return
        }
        val pivot = arr.hoarePartition(start, end)

        val left = QuickSortTask(arr, start, pivot)
        val right = QuickSortTask(arr, pivot + 1, end)
        left.fork()
        right.compute()
        left.join()
    }
}

fun main() {
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