package leetcode.`332-reconstruct-itinerary`.working

import java.util.*
import kotlin.collections.ArrayDeque

fun findItinerary(tickets: List<List<String>>): List<String> {
    val map = mutableMapOf<String, PriorityQueue<String>>()
    for (ticket in tickets) {
        map.getOrPut(ticket[0]) { PriorityQueue() }.add(ticket[1])
    }

    val itinerary = mutableListOf<String>()
    val stack = ArrayDeque<String>()

    stack += "JFK"

    while (stack.isNotEmpty()) {
        val current = stack.last()
        println("current: $current")
        if (map[current]?.isNotEmpty() == true) {
            println("not empty")
            // Push the next destination onto the stack
            stack += map[current]!!.remove()
        } else {
            println("empty: ${stack.last()}")
            // If no more destinations from current, pop from stack and add to itinerary
            itinerary.add(stack.removeLast())
        }
    }

    // Reverse the itinerary to get the correct order
    return itinerary.reversed()
}

fun main() {
    val tickets = listOf(
        listOf("MUC", "LHR"),
        listOf("JFK", "MUC"),
        listOf("SFO", "SJC"),
        listOf("LHR", "SFO")
    )

    val result = findItinerary(tickets)

    println(result)
    require(result == listOf("JFK", "MUC", "LHR", "SFO", "SJC"))
}