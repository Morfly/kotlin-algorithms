package foundation.sorting.`merge-sort`

import io.morfly.algorithms.tools.isSorted

fun IntArray.mergeSort() {
    mergeSort(this, copyOf(), start = 0, end = size)
}

fun mergeSort(arrA: IntArray, arrB: IntArray, start: Int, end: Int) {
    if (end - start < 2) return

    val mid = (start + end) / 2

    mergeSort(arrB, arrA, start, mid)
    mergeSort(arrB, arrA, mid, end)

    merge(arrB, arrA, start, mid, end)
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
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    array.mergeSort()

    println(array.joinToString())
    require(array.isSorted())
}