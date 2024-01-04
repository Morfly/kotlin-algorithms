package leetcode.`198-house-robber`

// https://leetcode.com/problems/house-robber
// https://youtu.be/73r3KWiEvyk?si=UsnAcvYExELPGPxX
fun rob(nums: IntArray): Int {
    var rob1 = 0
    var rob2 = 0

    for (num in nums) {
        val temp = maxOf(num + rob1, rob2)
        rob1 = rob2
        rob2 = temp
    }
    return rob2
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 1)

    val result = rob(nums)

    println(result)
    require(result == 4)
}