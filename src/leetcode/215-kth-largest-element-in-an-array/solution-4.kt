@file:Meta(companies = [Company.Meta], topics = [Topic.QuickSelect])

package leetcode.`215-kth-largest-element-in-an-array`.`solution-4`

@TimeComplexities(Worst("O(n^2)"), Average("O(n)"))
@SpaceComplexity("O(1)")
fun findKthLargest(nums: IntArray, k: Int): Int {
    val k = nums.size - k

    fun quickSelect(start: Int, end: Int): Int {
        val pivot = nums[end]
        var p = start
        for (i in start..<end) {
            if (nums[i] <= pivot) {
                nums[p] = nums[i].also { nums[i] = nums[p] }
                p++
            }
        }
        nums[p] = nums[end].also { nums[end] = nums[p] }

        return when {
            p > k -> quickSelect(start, end = p - 1)
            p < k -> quickSelect(start = p + 1, end)
            else -> nums[p]
        }
    }
    return quickSelect(start = 0, end = nums.lastIndex)
}

// https://www.youtube.com/watch?v=XEmy13g1Qxc
// https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/3906260/100-3-approaches-video-heap-quickselect-sorting/
fun main() {
    val input = intArrayOf(3, 2, 1, 5, 6, 4)

    val result = findKthLargest(input, k = 2)

    println(result)
    require(result == 5)
}