package foundation.`parallel-sorting`.`parallel-merge-sort`.coroutines

import foundation.sorting.`insertion-sort`.range.insertionSort
import foundation.sorting.`merge-sort`.mergeSort
import io.morfly.tools.isSorted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

private const val THRESHOLD = 100

suspend fun IntArray.parallelMergeSort() {
    parallelMergeSort(this, copyOf(), start = 0, end = size)
}

suspend fun parallelMergeSort(arr: IntArray, aux: IntArray, start: Int, end: Int) {
    if (end - start < THRESHOLD) {
        arr.insertionSort(start, end)
        return
    }
    val mid = (start + end) / 2

    coroutineScope {
        val left = launch(Dispatchers.Default) { parallelMergeSort(aux, arr, start, mid) }
        val right = launch(Dispatchers.Default) { parallelMergeSort(aux, arr, mid, end) }
        left.join()
        right.join()

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

fun main() = runBlocking {
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