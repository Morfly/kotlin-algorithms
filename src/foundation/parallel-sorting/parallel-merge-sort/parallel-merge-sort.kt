package foundation.`parallel-sorting`.`parallel-merge-sort`

import foundation.sorting.`insertion-sort`.insertionSort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.RecursiveAction
import kotlin.random.Random

private const val THRESHOLD = 1000

suspend fun IntArray.parallelMergeSort() {
    parallelMergeSort(this, copyOf(), start = 0, end = size)
}

suspend fun parallelMergeSort(arr: IntArray, aux: IntArray, start: Int, end: Int) {
    if (end - start < THRESHOLD) {
        arr.insertionSort()
    } else {
        val mid = (start + end) / 2
        coroutineScope {
//            withContext(Dispatchers.Default) {parallelMergeSort(aux, arr, start, mid)}
//            withContext(Dispatchers.Default) {parallelMergeSort(aux, arr, mid, end)}
            val left = launch(Dispatchers.Default) { parallelMergeSort(aux, arr, start, mid) }
            val right = launch(Dispatchers.Default) { parallelMergeSort(aux, arr, mid, end) }
            left.join()
            right.join()

            merge(aux, arr, start, mid, end)
        }
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
    val time = System.currentTimeMillis()
    val array = IntArray(2_000_000_0) { Random.nextInt(1, Int.MAX_VALUE) }

    array.parallelMergeSort()

    println("done in ${System.currentTimeMillis() - time}")
//    println(array.joinToString())
//    require(isSorted(array))

    object : RecursiveAction() {
        override fun compute() {

        }
    }
}

fun isSorted(array: IntArray): Boolean {
    for (i in 0 until array.size - 1) {
        if (array[i] > array[i + 1]) {
            return false
        }
    }
    return true
}