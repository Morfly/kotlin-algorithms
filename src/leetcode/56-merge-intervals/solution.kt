@file:Problem(companies = [Company.Meta], topics = [Topic.Sorting, Topic.Intervals])

package leetcode.`56-merge-intervals`

@TimeComplexity("O(n log n)")
@SpaceComplexity("O(n)")
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()

    val sorted = intervals.sortedBy { it[0] }

    for (interval in sorted) {
        if (result.isEmpty()) {
            result += interval
        } else {
            val lastInterval = result.last()
            if (lastInterval[1] < interval[0]) {
                result += interval
            } else {
                lastInterval[1] = maxOf(lastInterval[1], interval[1])
            }
        }
    }

    return result.toTypedArray()
}

fun main() {
    val input = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))

    val result = merge(input).map(IntArray::toList)

    println(result)
    require(result == listOf(listOf(1, 6), listOf(8, 10), listOf(15, 18)))
}