@file:SortingAlgorithm(
    Stable(true), InPlace(false), Comparative(false), Recursive(false),
    comment = "Efficient when the range of input values is small compared to the number of elements to be sorted."
)

package foundation.sorting.`counting-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n + k)", Comment("n is the array size, k is the max element in the array."))
@SpaceComplexity("O(n + k)")
fun countingSort(array: IntArray) {
    val max = array.max()
    val count = IntArray(max + 1)

    for (element in array) {
        count[element]++
    }

    for (i in 1..count.lastIndex) {
        count[i] += count[i - 1]
    }

    val output = IntArray(array.size)
    for (i in array.lastIndex downTo 0) {
        val elementCount = count[array[i]]
        output[elementCount - 1] = array[i]
        count[array[i]]--
    }

    output.copyInto(array)
}

// https://youtu.be/EItdcGhSLf4?si=O65RX602_NfpJwR2
// https://www.programiz.com/dsa/counting-sort
fun main() {
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    countingSort(array)

    println(array.joinToString())
    require(array.isSorted())
}