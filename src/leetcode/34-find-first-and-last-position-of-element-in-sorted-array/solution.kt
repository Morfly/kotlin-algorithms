@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.BinarySearch])

package leetcode.`34-find-first-and-last-position-of-element-in-sorted-array`

enum class Bound { MostLeft, MostRight }

@TimeComplexity("O(log n)")
@SpaceComplexity("O(1)")
fun searchRange(nums: IntArray, target: Int): IntArray {

    fun find(bound: Bound): Int {
        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            val mid = (start + end) / 2
            val guess = nums[mid]

            when {
                guess < target -> start = mid + 1
                guess > target -> end = mid - 1
                else -> when (bound) {
                    Bound.MostLeft -> {
                        if (mid == 0 || nums[mid - 1] != target) return mid
                        else end = mid - 1
                    }

                    Bound.MostRight -> {
                        if (mid == nums.lastIndex || nums[mid + 1] != target) return mid
                        else start = mid + 1
                    }
                }
            }
        }
        return -1
    }
    return intArrayOf(find(Bound.MostLeft), find(Bound.MostRight))
}

fun main() {
    val input = intArrayOf(5, 7, 7, 8, 8, 10)

    val result = searchRange(input, target = 8).toList()

    println(result)
    require(result == listOf(3, 4))
}