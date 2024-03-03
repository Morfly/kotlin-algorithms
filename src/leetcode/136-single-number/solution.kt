@file:Problem(topics = [Topic.BitManipulation])

package leetcode.`136-single-number`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun singleNumber(nums: IntArray): Int {
    var value = 0
    for (num in nums) {
        value = value xor num
    }

    return value
}

fun main() {
    val input = intArrayOf(4, 1, 2, 1, 2)

    val result = singleNumber(input)

    println(result)
    require(result == 4)
}