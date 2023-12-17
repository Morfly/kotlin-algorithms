package leetcode.`1`

// https://leetcode.com/problems/two-sum/
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val complement = map[target - nums[i]]
        if (complement != null) {
            return intArrayOf(complement, i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)

    val result = twoSum(nums, target = 9).toList()

    println(result)
    require(result == listOf(0, 1))
}