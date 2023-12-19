package foundation.sorting.`quick-sort`

import foundation.sorting.`quick-sort`.partition.hoarePartition
import io.morfly.algorithms.tools.isSorted

fun IntArray.quickSort() {
    shuffle()
    quickSort(0, size)
}

fun IntArray.quickSort(start: Int, end: Int) {
    if (end - start < 2) return

    val pivot = hoarePartition(start, end)
    quickSort(start, pivot)
    quickSort(pivot + 1, end)
}


fun main() {
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    array.quickSort()

    println(array.joinToString())
    require(array.isSorted())
}