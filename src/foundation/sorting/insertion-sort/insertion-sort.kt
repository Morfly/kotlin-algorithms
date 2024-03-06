// One of the most efficient algorithms for sorting small arrays of data.
@file:SortingAlgorithm(stable.yes, `in-place`.yes, comparative.yes, recursive.no)

package foundation.sorting.`insertion-sort`

import io.morfly.algorithms.tools.*

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun IntArray.insertionSort() {
    for (i in 1..lastIndex) {
        var j = i
        val arri = array[i]
        while (j > 0 && arri < array[j - 1]) {
            array[j] = array[j - 1]
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