package foundation.`parallel-sorting`.`parallel-merge-sort`.`fork-join`

import foundation.sorting.`insertion-sort`.range.insertionSort
import foundation.sorting.`merge-sort`.mergeSort
import io.morfly.tools.isSorted
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveAction
import kotlin.random.Random
import kotlin.system.measureTimeMillis

private const val THRESHOLD = 100

fun IntArray.parallelMergeSort() {
    ForkJoinPool().invoke(MergeSortTask(this, copyOf(), start = 0, end = size))
}

class MergeSortTask(
    private val arr: IntArray,
    private val aux: IntArray,
    private val start: Int,
    private val end: Int
) : RecursiveAction() {
    
    override fun compute() {
        if (end - start < THRESHOLD) {
            arr.insertionSort(start, end)
            return
        }

        val mid = (start + end) / 2
        val left = MergeSortTask(aux, arr, start, mid)
        val rightTask = MergeSortTask(aux, arr, mid, end)

        left.fork()
        rightTask.compute()
        left.join()

        merge(aux, arr, start, mid, end)
    }
}

fun merge(arr: IntArray, aux: IntArray, start: Int, mid: Int, end: Int) {
    var i = start
    var j = mid
    for (k in start until end) {
        if (i < mid && (j >= end || arr[i] <= arr[j]))
            aux[k] = arr[i++]
        else aux[k] = arr[j++]
    }
}

fun main() {
    // Parallel merge sort. Takes ~7 sec.
    val array1 = IntArray(200_000_000) { Random.nextInt(1, Int.MAX_VALUE) }
    val time1 = measureTimeMillis {
        array1.parallelMergeSort()
    }
    println("Parallel merge sort: $time1")
    require(array1.isSorted())

    // Merge sort. Takes ~29 sec.
    val array2 = IntArray(200_000_000) { Random.nextInt(1, Int.MAX_VALUE) }
    val time2 = measureTimeMillis {
        array2.mergeSort()
    }
    println("Merge sort: $time2")
    require(array2.isSorted())
}