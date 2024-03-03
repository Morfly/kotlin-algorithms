@file:SortingAlgorithm(Stable(true), InPlace(false), Comparative(false), Recursive(false))

package foundation.sorting.`radix-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n + k)", Comment("n is the array size, k is the max element in the array."))
@SpaceComplexity("O(n + k)")
fun radixSort(array: IntArray) {
    val max = array.max()

    var place = 1
    while (max / place > 0) {
        countingSort(array, place)
        place *= 10
    }
}

fun countingSort(array: IntArray, place: Int) {
    val max = array.max()
    val count = IntArray(max + 1)

    for (element in array) {
        val digit = (element / place) % 10
        count[digit]++
    }

    for (i in 1..count.lastIndex) {
        count[i] += count[i - 1]
    }

    val output = IntArray(array.size)
    for (i in array.lastIndex downTo 0) {
        val digit = (array[i] / place) % 10
        val elementCount = count[digit]
        output[elementCount - 1] = array[i]
        count[digit]--
    }

    output.copyInto(array)
}

fun main() {
    val array = intArrayOf(121, 432, 564, 23, 1, 45, 788)

    radixSort(array)

    println(array.joinToString())
    require(array.isSorted())
}