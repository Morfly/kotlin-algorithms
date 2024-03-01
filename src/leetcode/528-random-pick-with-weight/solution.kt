@file:Meta(companies = [Company.Meta], topics = [Topic.BinarySearch])

package leetcode.`528-random-pick-with-weight`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
class Solution(w: IntArray) {
    private val weights = mutableListOf<Int>()
    private val total: Int

    init {
        var sum = 0
        for (i in w.indices) {
            sum += w[i]
            weights += sum
        }
        total = sum
    }

    @TimeComplexity("O(log n)")
    @SpaceComplexity("O(1)")
    fun pickIndex(): Int {
        val rand = (1..total).random()

        var start = 0
        var end = weights.lastIndex
        while (start <= end) {
            val mid = (start + end) / 2
            val guess = weights[mid]
            when {
                guess > rand -> end = mid - 1
                guess < rand -> start = mid + 1
                else -> return mid
            }
        }
        return start
    }
}

fun main() {
    val obj = Solution(intArrayOf(1, 3))

    val result = obj.pickIndex()

    println(result)
    require(result == 0 || result == 1)
}