package leetcode.`332-reconstruct-itinerary`.slow

// https://leetcode.com/problems/reconstruct-itinerary/
fun findItinerary(tickets: List<List<String>>): List<String> {
    val graph = mutableMapOf<String, MutableList<String?>>()
    for ((src, dest) in tickets.sortedWith(compareBy({ it.first() }, { it.last() }))) {
        graph.getOrPut(src) { mutableListOf() } += dest
    }

    val itinerary = mutableListOf("JFK")

    fun traverse(src: String): Boolean {
        if (itinerary.size == tickets.size + 1) return true
        if (src !in graph) return false

        val destinations = graph[src].orEmpty().toList()
        for (i in destinations.indices) {
            val dest = destinations[i] ?: continue

            graph[src]!![i] = null
            itinerary += dest

            if (traverse(dest)) return true

            itinerary.removeLast()
            graph[src]!![i] = dest
        }
        return false
    }
    traverse("JFK")

    return itinerary
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