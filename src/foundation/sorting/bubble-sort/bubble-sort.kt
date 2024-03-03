@file:SortingAlgorithm(Stable(true), InPlace(true), Comparative(true), Recursive(false))

package foundation.sorting.`bubble-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun IntArray.bubbleSort() {
    for (i in 0..<lastIndex) {
        for (j in 0..<lastIndex - i) {
            if (this[j] > this[j + 1]) {
                swap(j, j + 1)
            }
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    array.bubbleSort()

    println(array.joinToString())
    require(array.isSorted())
}