@file:SortingAlgorithm(Stable(true), InPlace(true), Comparative(true), Recursive(false))

package foundation.sorting.`bubble-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun bubbleSort(array: IntArray) {
    for (i in 0..<array.lastIndex) {
        for (j in 0..<array.lastIndex - i) {
            if (array[j] > array[j + 1]) {
                array.swap(j, j + 1)
            }
        }
    }
}

fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    bubbleSort(array)

    println(array.joinToString())
    require(array.isSorted())
}