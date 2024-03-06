@file:SortingAlgorithm(stable.no, `in-place`.yes, comparative.yes, recursive.no)

package foundation.sorting.`heap-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n log n)")
@SpaceComplexity("O(1)")
fun IntArray.heapSort() {
    // TODO
}

// https://www.programiz.com/dsa/heap-sort
fun main() {
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    array.heapSort()

    println(array.joinToString())
    require(array.isSorted())
}