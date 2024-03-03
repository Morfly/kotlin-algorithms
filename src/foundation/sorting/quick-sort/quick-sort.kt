// One of the most efficient sorting algorithms.
@file:SortingAlgorithm(Stable(false), InPlace(true), Comparative(true), Recursive(true))

package foundation.sorting.`quick-sort`

import foundation.sorting.`quick-sort`.partition.hoare.hoarePartition
import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n log n)")
@SpaceComplexity("O(log n)")
fun IntArray.quickSort() {
    shuffle()
    quickSort(start = 0, end = size)
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