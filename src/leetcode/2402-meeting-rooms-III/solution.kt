package leetcode.`2402-meeting-rooms-III`

import java.util.*

data class Busy(val end: Long, val room: Int)

// https://leetcode.com/problems/meeting-rooms-iii/description/
// https://youtu.be/aZ_vuZxlB4I?si=1KBv4_z0aRHBzNu0
fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    val busy = PriorityQueue<Busy>(n, compareBy({ it.end }, { it.room }))
    val available = PriorityQueue<Int>()
    available += 0 until n
    val count = IntArray(n)

    meetings.sortBy { it.first() }

    for ((start, end) in meetings) {
        while (busy.isNotEmpty() && busy.peek().end <= start) {
            val room = busy.remove().room
            available += room
        }

        if (available.isNotEmpty()) {
            val room = available.remove()
            busy += Busy(end.toLong(), room)
            count[room]++
        } else {
            val (prevEnd, room) = busy.remove()
            busy += Busy(end = prevEnd + end - start, room)
            count[room]++
        }
    }

    return count.indexOf(count.max())
}

fun main() {
    val meetings = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(1, 5),
        intArrayOf(2, 7),
        intArrayOf(3, 4)
    )

    val result = mostBooked(n = 2, meetings)

    println(result)
    require(result == 0)
}