package leetcode.`350-intercection-of-two-arrays-II`

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val nums = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()

    for (num in nums1) {
        nums[num] = nums.getOrDefault(num, 0) + 1
    }

    for (num in nums2) {
        val numCount = nums[num] ?: continue
        if (numCount > 0) {
            result += num
            nums[num] = numCount - 1
        }
    }

    return result.toIntArray()
}

fun main() {
    val nums1 = intArrayOf(4, 9, 5)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)

    val result = intersect(nums1, nums2).toList()

    println(result)
    require(result == listOf(9, 4))
}