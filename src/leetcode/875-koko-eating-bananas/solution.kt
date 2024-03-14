@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.BinarySearch])

package leetcode.`875-koko-eating-bananas`

import kotlin.math.ceil

@TimeComplexity("O(log(max(p)) p)")
@SpaceComplexity("O(1)")
fun minEatingSpeed(piles: IntArray, h: Int): Int {

    fun canEat(k: Int): Boolean {
        var hours = 0
        for (pile in piles) {
            hours += ceil(pile / k.toDouble()).toInt()
            if (hours > h) return false
        }
        return true
    }

    var start = 1
    var end = piles.max()

    var minK = 0
    while (start <= end) {
        val k = (start + end) / 2
        val canEat = canEat(k)
        if (canEat) minK = k

        if (canEat) end = k - 1
        else start = k + 1

    }
    return minK
}


fun main() {
    val input = intArrayOf(30, 11, 23, 4, 20)

    val result = minEatingSpeed(input, h = 5)

    println(result)
    require(result == 30)
}