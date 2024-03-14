@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.BinarySearch])

package leetcode.`1011-capacity-to-ship-packages-within-d-days`

@TimeComplexity("O(n log(sum(w)))")
@SpaceComplexity("O(1)")
fun shipWithinDays(weights: IntArray, days: Int): Int {

    fun canShip(capacity: Int): Boolean {
        var daysSoFar = 1
        var currCapacity = capacity
        for (w in weights) {
            if (currCapacity - w < 0) {
                daysSoFar++
                currCapacity = capacity
            }
            currCapacity -= w
        }
        return daysSoFar <= days
    }

    var start = weights.max()
    var end = weights.sum()

    var minCapacity = end
    while (start <= end) {
        val capacity = (start + end) / 2
        if (canShip(capacity)) {
            minCapacity = capacity
            end = capacity - 1
        } else {
            start = capacity + 1
        }
    }
    return minCapacity
}

fun main() {
    val input = intArrayOf(3, 2, 2, 4, 1, 4)

    val result = shipWithinDays(input, days = 3)

    println(result)
    require(result == 6)
}