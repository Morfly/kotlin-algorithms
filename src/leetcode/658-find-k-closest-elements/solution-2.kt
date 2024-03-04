@file:Problem(companies = [Company.Meta], topics = [Topic.SlidingWindow, Topic.TwoPointers])

package leetcode.`658-find-k-closest-elements`.`solution-2`

import kotlin.math.abs

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var start = 0
    var end = arr.lastIndex
    while (end - start + 1 > k) {
        if (abs(arr[start] - x) > abs(arr[end] - x)) {
            start++
        } else {
            end--
        }
    }

    val result = mutableListOf<Int>()
    for (i in start..end)
        result += arr[i]

    return result
}

fun main() {
    val input = intArrayOf(0, 0, 0, 1, 3, 5, 6, 7, 8, 8)

    val result = findClosestElements(input, k = 2, x = 2)

    println(result)
    require(result == listOf(1, 3))
}