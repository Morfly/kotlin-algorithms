@file:Problem(companies = [Company.Meta], topics = [Topic.Queue])

package leetcode.`346-moving-average-from-data-stream`

class MovingAverage(val size: Int) {
    private val queue = ArrayDeque<Int>(size)
    private var sum = 0.0

    // n is a size.
    @TimeComplexity("O(1)")
    @SpaceComplexity("O(n)")
    fun next(`val`: Int): Double {
        queue += `val`
        sum += `val`
        if (queue.size > size) {
            sum -= queue.removeFirst()
        }
        return sum / queue.size
    }
}

fun main() {
    val obj = MovingAverage(size = 3)

    val results = mutableListOf<Double>()

    results += obj.next(1).format()
    results += obj.next(10).format()
    results += obj.next(3).format()
    results += obj.next(5).format()

    println(results)
    require(results == listOf(1.0, 5.5, 4.66667, 6.0))
}

