@file:SortingAlgorithm(Stable(false), InPlace(true), Comparative(true), Recursive(false))

package foundation.sorting.`selection-sort`

import io.morfly.algorithms.tools.*

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(1)")
fun IntArray.selectionSort() {
    for (step in 0..<array.lastIndex) {
        var currMin = step

        for (i in (step + 1)..array.lastIndex) {
            if (array[i] < array[currMin]) {
                currMin = i
            }
        }

        swap(step, currMin)
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    array[i] = array[j].also { array[j] = array[i] }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.selectionSort()

    println(array.joinToString())
    require(array.isSorted())
}