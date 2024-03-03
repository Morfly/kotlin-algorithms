// Efficient when the range of input values is small compared to the number of elements to be sorted.
@file:SortingAlgorithm(Stable(true), InPlace(false), Comparative(false), Recursive(false))

package foundation.sorting.`counting-sort`

import io.morfly.algorithms.tools.*

// n - array size, k - max element in the array.
@TimeComplexity("O(n + k)")
@SpaceComplexity("O(n + k)")
fun IntArray.countingSort() {
    val max = max()
    val count = IntArray(max + 1)

    for (element in array) {
        count[element]++
    }

    for (i in 1..count.lastIndex) {
        count[i] += count[i - 1]
    }

    val output = IntArray(array.size)
    for (i in lastIndex downTo 0) {
        val elementCount = count[array[i]]
        output[elementCount - 1] = array[i]
        count[array[i]]--
    }

    output.copyInto(this)
}

// https://youtu.be/EItdcGhSLf4?si=O65RX602_NfpJwR2
// https://www.programiz.com/dsa/counting-sort
fun main() {
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    array.countingSort()

    println(array.joinToString())
    require(array.isSorted())
}