@file:Problem(companies = [Company.Meta], topics = [Topic.BinarySearch])

package leetcode.`153-find-minimum-in-rotated-sorted-array`

fun findMin(nums: IntArray): Int {
    var start = 0
    var end = nums.lastIndex

    var res = nums[0]

    while (start <= end) {
        if (nums[start] < nums[end]) {
            res = minOf(res, nums[start])
            break
        }
        val mid = (start + end) / 2
        res = minOf(res, nums[mid])

        if (nums[mid] >= nums[start]) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return res
}

fun main() {
    val input = intArrayOf(4, 5, 6, 7, 0, 1, 2)

    val result = findMin(input)

    println(result)
    require(result == 0)
}