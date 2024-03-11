@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Sorting, Topic.TwoPointers])

package leetcode.`253-meeting-rooms-II`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val starts = intervals.map { it[0] }.sorted()
    val ends = intervals.map { it[1] }.sorted()

    var count = 0
    var max = 0

    var start = 0
    var end = 0
    while (start <= starts.lastIndex) {
        if (starts[start] < ends[end]) {
            start++
            count++
            max = maxOf(max, count)
        } else if (starts[start] > ends[end]) {
            end++
            count--
        } else {
            start++
            end++
        }
    }
    return max
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 30),
        intArrayOf(5, 10),
        intArrayOf(15, 20),
    )

    val result = minMeetingRooms(input)

    println(result)
    require(result == 2)
}