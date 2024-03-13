@file:Problem(companies = [Company.Meta], topics = [Topic.TwoPointers, Topic.Array])

package leetcode.`167-two-sum-II-input-array-is-sorted`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun twoSum(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.lastIndex

    while (start < end) {
        when {
            numbers[start] + numbers[end] > target -> end--
            numbers[start] + numbers[end] == target -> return intArrayOf(start + 1, end + 1)
            else -> start++
        }
    }
    return intArrayOf()
}

fun main() {
    val input = intArrayOf(1, 3, 4, 5, 7, 10, 11)

    val result = twoSum(input, target = 9).toList()

    println(result)
    require(result == listOf(3, 4))
}