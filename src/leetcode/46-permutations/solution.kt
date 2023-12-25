package leetcode.`46-permutations`

// https://leetcode.com/problems/permutations/
fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(tmp: LinkedHashSet<Int>) {
        if (tmp.size == nums.size) {
            result += tmp.toList()
        } else {
            for (num in nums) {
                if (num in tmp) continue
                tmp += num
                backtrack(tmp)
                tmp -= num
            }
        }
    }
    backtrack(linkedSetOf())

    return result
}

fun main() {
    val nums = intArrayOf(1, 2, 3)

    val result = permute(nums)

    println(result)
    require(
        result == listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1),
        )
    )
}