@file:Problem(companies = [Company.Meta], topics = [Topic.SlidingWindow, Topic.TwoPointers])

package leetcode.`658-find-k-closest-elements`.`solution-1`

import kotlin.math.abs

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var start = 0
    var end = k - 1
    for (i in k..arr.lastIndex) {
        if (abs(arr[i] - x) < abs(arr[start] - x)) {
            end = i
            start = end - k + 1
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