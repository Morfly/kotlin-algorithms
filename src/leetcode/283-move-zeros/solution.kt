package leetcode.`283-move-zeros`

fun moveZeroes(nums: IntArray) {
    var left = 0
    var right = 0

    while (right < nums.size) {
        if (nums[right] != 0) {
            nums[left] = nums[right].also { nums[right] = nums[left] }
            left++
        }
        right++
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)

    moveZeroes(nums)

    println(nums.joinToString())
    require(nums.toList() == listOf(1, 3, 12, 0, 0))
}