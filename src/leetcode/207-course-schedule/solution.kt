package leetcode.`207-course-schedule`

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()

    for ((course, dependency) in prerequisites) {
        graph.getOrPut(dependency, ::mutableListOf) += course
    }

    val explored = mutableSetOf<Int>()
    val schedule = linkedSetOf<Int>()
    var valid = true

    fun topSort(course: Int) {
        explored += course
        for (successor in graph[course].orEmpty()) {
            if (successor !in explored) {
                if (!valid) return
                topSort(successor)
            } else if (successor !in schedule) {
                valid = false
                return
            }
        }
        schedule += course
    }

    for ((course, _) in graph) {
        if (course !in explored) {
            topSort(course)
            if (!valid) return false
        }
    }
    return true
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2, 4),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
    )

    val result = canFinish(numCourses = 5, input)

    println(result)
    require(result)
}