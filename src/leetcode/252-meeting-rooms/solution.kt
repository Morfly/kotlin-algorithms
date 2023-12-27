package leetcode.`252-meeting-rooms`

fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
    intervals.sortBy { it[0] }

    var prevEnd: Int? = null
    for ((start, end) in intervals) {
        if (prevEnd != null && start < prevEnd) {
            return false
        }
        prevEnd = end
    }

    return true
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(0, 30),
        intArrayOf(5, 10),
        intArrayOf(15, 20)
    )

    val result = canAttendMeetings(intervals)

    println(result)
    require(!result)
}