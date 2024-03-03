@file:SortingAlgorithm(
    Stable(true), InPlace(true), Comparative(true), Recursive(false),
    "One of the most efficient algorithms for sorting small arrays of data."
)

package foundation.sorting.`insertion-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun IntArray.insertionSort() {
    for (i in 1..lastIndex) {
        var j = i
        val arri = this[i]
        while (j > 0 && arri < this[j - 1]) {
            this[j] = this[j - 1]
            j--
        }
        this[j] = arri
    }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.insertionSort()

    println(array.joinToString())
    require(array.isSorted())
}