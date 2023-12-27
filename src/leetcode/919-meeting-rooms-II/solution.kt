package leetcode.`919-meeting-rooms-II`


fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val starts = IntArray(intervals.size) { intervals[it].first() }
    val ends = IntArray(intervals.size) { intervals[it].last() }
    starts.sort()
    ends.sort()

    var count = 0
    var max = 0

    var start = 0
    var end = 0
    while (start < starts.size) {
        when {
            starts[start] < ends[end] -> {
                start++
                count++
                max = maxOf(max, count)
            }

            ends[end] < starts[start] -> {
                end++
                count--
            }

            else -> {
                start++
                end++
            }
        }
    }

    return max
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(0, 30),
        intArrayOf(5, 10),
        intArrayOf(15, 20)
    )

    val result = minMeetingRooms(intervals)

    println(result)
    require(result == 2)
}