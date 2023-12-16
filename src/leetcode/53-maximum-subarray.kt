package leetcode

import kotlin.math.max

// https://leetcode.com/problems/maximum-subarray/description/
// https://youtu.be/5WZl3MMT0Eg?si=is4N27GpnLbUUVo6
fun maxSubarray(nums: IntArray): Int {
    var maxSub = nums[0]
    var currSum = 0

    for (n in nums) {
        if (currSum < 0) {
            currSum = 0
        }
        currSum += n
        maxSub = max(maxSub, currSum)
    }
    return maxSub
}

fun main() {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    val result = maxSubarray(nums)

    println(result)
    require(result == 6)
}