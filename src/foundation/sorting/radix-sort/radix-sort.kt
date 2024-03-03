@file:SortingAlgorithm(Stable(true), InPlace(false), Comparative(false), Recursive(false))

package foundation.sorting.`radix-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexity("O(n + k)", Comment("n is the array size, k is the max element in the array."))
@SpaceComplexity("O(n + k)")
fun IntArray.radixSort() {
    val max = max()

    var place = 1
    while (max / place > 0) {
        countingSort(place)
        place *= 10
    }
}

fun IntArray.countingSort(place: Int) {
    val max = max()
    val count = IntArray(max + 1)

    for (element in this) {
        val digit = (element / place) % 10
        count[digit]++
    }

    for (i in 1..count.lastIndex) {
        count[i] += count[i - 1]
    }

    val output = IntArray(size)
    for (i in lastIndex downTo 0) {
        val digit = (this[i] / place) % 10
        val elementCount = count[digit]
        output[elementCount - 1] = this[i]
        count[digit]--
    }

    output.copyInto(this)
}

fun main() {
    val array = intArrayOf(121, 432, 564, 23, 1, 45, 788)

    array.radixSort()

    println(array.joinToString())
    require(array.isSorted())
}