package leetcode.`152`

// https://leetcode.com/problems/maximum-product-subarray/description/
// https://youtu.be/lXVy6YWFcRM?si=7TZKvgwyCBbDH8wI
fun maxProduct(nums: IntArray): Int {
    var maxProduct = nums.max()
    var currMax = 1
    var currMin = 1

    for (n in nums) {
        val nCurrMax = n * currMax
        val nCurrMin = n * currMin

        currMax = maxOf(n, nCurrMax, nCurrMin)
        currMin = minOf(n, nCurrMax, nCurrMin)
        maxProduct = maxOf(maxProduct, currMax, currMin)
    }
    return maxProduct
}

fun main() {
    val nums = intArrayOf(2, 3, -2, 4)

    val result = maxProduct(nums)

    println(result)
    require(result == 6)
}