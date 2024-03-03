@file:SortingAlgorithm(
    Stable(true), InPlace(true), Comparative(true), Recursive(false),
    "One of the most efficient algorithms for sorting small arrays of data."
)

package foundation.sorting.`insertion-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun insertionSort(array: IntArray) {
    for (i in 1..array.lastIndex) {
        var j = i
        val arri = array[i]
        while (j > 0 && arri < array[j - 1]) {
            array[j] = array[j - 1]
            j--
        }
        array[j] = arri
    }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    insertionSort(array)

    println(array.joinToString())
    require(array.isSorted())
}