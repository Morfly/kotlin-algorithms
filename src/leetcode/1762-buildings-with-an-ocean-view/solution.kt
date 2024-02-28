@file:Meta(companies = [Company.Meta])

package leetcode.`1762-buildings-with-an-ocean-view`

fun findBuildings(heights: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var height = 0
    for (i in heights.lastIndex downTo 0) {
        if (heights[i] > height) {
            height = heights[i]
            result += i
        }
    }
    return result.asReversed().toIntArray()
}

fun main() {
    val input = intArrayOf(4, 2, 3, 1)

    val result = findBuildings(input).toList()

    println(result)
    require(result == listOf(0, 2, 3))
}