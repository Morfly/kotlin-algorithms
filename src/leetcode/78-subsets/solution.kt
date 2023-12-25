package leetcode.`78-subsets`

// https://leetcode.com/problems/subsets/
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    fun backtrack(tmp: MutableList<Int>, start: Int) {
        result += tmp.toList()
        for (i in start..nums.lastIndex) {
            tmp += nums[i]
            backtrack(tmp, i + 1)
            tmp.removeLast()
        }
    }
    backtrack(mutableListOf(), start = 0)

    return result
}

fun main() {
    val nums = intArrayOf(1, 2, 3)

    val result = subsets(nums)

    println(result)
    require(
        result == listOf(
            listOf(),
            listOf(1),
            listOf(1, 2),
            listOf(1, 2, 3),
            listOf(1, 3),
            listOf(2),
            listOf(2, 3),
            listOf(3),
        )
    )
}