package leetcode.`332-reconstruct-itinerary`

import java.util.*

// https://leetcode.com/problems/reconstruct-itinerary/description/
fun findItinerary(tickets: List<List<String>>): List<String> {
    val graph = mutableMapOf<String, PriorityQueue<String>>()
    for ((src, dest) in tickets) {
        graph.getOrPut(src) { PriorityQueue() } += dest
    }
    val itinerary = mutableListOf<String>()

    fun dfs(src: String) {
        val destinations = graph[src]
        while (!destinations.isNullOrEmpty()) {
            dfs(destinations.remove())
        }
        itinerary += src
    }
    dfs("JFK")

    return itinerary.asReversed()
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