package foundation.search.binary.recursive

fun IntArray.search(value: Int): Int {

    tailrec fun search(start: Int, end: Int): Int {
        if (start > end) return -1

        val mid = (start + end) / 2
        val guess = this[mid]
        return when {
            value < guess -> search(start, mid - 1)
            value > guess -> search(mid + 1, end)
            else -> mid
        }
    }

    return search(start = 0, end = lastIndex)
}

fun main() {
    val sortedList = intArrayOf(1, 2, 3, 5, 8, 9, 10)
    val index = sortedList.search(8)

    println(index)
    require(index == 4)
}