package leetcode.`90-subsets-II`

// https://leetcode.com/problems/subsets-ii/
fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    fun backtrack(tmp: MutableList<Int>, start: Int) {
        result += tmp.toList()
        for (i in start..nums.lastIndex) {
            if (i > start && nums[i] == nums[i - 1]) continue
            tmp += nums[i]
            backtrack(tmp, i + 1)
            tmp.removeLast()
        }
    }
    backtrack(mutableListOf(), start = 0)

    return result
}

fun main() {
    val nums = intArrayOf(1, 2, 2)

    val result = subsetsWithDup(nums)

    println(result)
    require(
        result == listOf(
            listOf(),
            listOf(1),
            listOf(1, 2),
            listOf(1, 2, 2),
            listOf(2),
            listOf(2, 2),
        )
    )
}