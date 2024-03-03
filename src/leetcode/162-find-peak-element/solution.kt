@file:Problem(companies = [Company.Meta], topics = [Topic.BinarySearch])

package leetcode.`162-find-peak-element`

@TimeComplexity("O(log n)")
@SpaceComplexity("O(1)")
fun findPeakElement(nums: IntArray): Int {
    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val mid = (start + end) / 2
        val guess = nums[mid]

        val greaterThanLeft = mid == 0 || guess > nums[mid - 1]
        val greaterThanRight = mid == nums.lastIndex || guess > nums[mid + 1]

        when {
            greaterThanLeft && greaterThanRight -> return mid
            greaterThanLeft -> start = mid + 1
            else -> end = mid - 1
        }
    }
    return 0
}

fun main() {
    val input = intArrayOf(1, 2, 1, 3, 5, 6, 4)

    val result = findPeakElement(input)

    println(result)
    require(result == 5)
}