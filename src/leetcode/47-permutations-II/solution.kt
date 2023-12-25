package leetcode.`47-permutations-II`

// https://leetcode.com/problems/permutations-ii/
fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val used = BooleanArray(nums.size)
    nums.sort()

    fun backtrack(tmp: MutableList<Int>) {
        if (tmp.size == nums.size) {
            result += tmp.toList()
        } else {
            for (i in nums.indices) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue
                used[i] = true
                tmp += nums[i]
                backtrack(tmp)
                tmp.removeLast()
                used[i] = false
            }
        }
    }
    backtrack(mutableListOf())

    return result
}

fun main() {
    val nums = intArrayOf(1, 1, 2)

    val result = permuteUnique(nums)

    println(result)
    require(
        result == listOf(
            listOf(1, 1, 2),
            listOf(1, 2, 1),
            listOf(2, 1, 1),
        )
    )
}