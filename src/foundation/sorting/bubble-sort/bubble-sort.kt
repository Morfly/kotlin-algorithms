@file:SortingAlgorithm(Stable(true), InPlace(true), Comparative(true), Recursive(false))

package foundation.sorting.`bubble-sort`

import io.morfly.algorithms.tools.*

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun IntArray.bubbleSort() {
    for (i in 0..<array.lastIndex) {
        for (j in 0..<array.lastIndex - i) {
            if (array[j] > array[j + 1]) {
                swap(j, j + 1)
            }
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    array[i] = array[j].also { array[j] = array[i] }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    array.bubbleSort()

    println(array.joinToString())
    require(array.isSorted())
}