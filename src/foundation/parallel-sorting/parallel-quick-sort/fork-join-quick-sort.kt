package foundation.`parallel-sorting`.`parallel-quick-sort`

import foundation.sorting.`insertion-sort`.range.insertionSort
import foundation.sorting.`quick-sort`.partition.hoare.hoarePartition
import foundation.sorting.`quick-sort`.quickSort
import io.morfly.algorithms.tools.*
import java.util.concurrent.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

private const val THRESHOLD = 100

fun IntArray.parallelQuickSort() {
    shuffle()
    ForkJoinPool().invoke(QuickSortTask(array, 0, array.size))
}

class QuickSortTask(
    private val array: IntArray,
    private val start: Int,
    private val end: Int
) : RecursiveAction() {

    override fun compute() {
        if (end - start < THRESHOLD) {
            array.insertionSort(start, end)
            return
        }
        val pivot = array.hoarePartition(start, end)

        val left = QuickSortTask(array, start, pivot)
        val right = QuickSortTask(array, pivot + 1, end)
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