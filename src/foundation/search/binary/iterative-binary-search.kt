package foundation.search.binary.iterative

fun IntArray.search(value: Int): Int {
    var start = 0
    var end = lastIndex
    while (start <= end) {
        val mid = (start + end) / 2
        val guess = this[mid]
        when {
            value < guess -> end = mid - 1
            value > guess -> start = mid + 1
            else -> return mid
        }
    }
    return -1
}

fun main() {
    val sortedList = intArrayOf(1, 2, 3, 5, 8, 9, 10)
    val index = sortedList.search(8)

    println(index)
    require(index == 4)
}