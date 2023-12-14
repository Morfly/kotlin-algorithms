package foundation.search.linear

fun <T> List<T>.search(value: T): Int {
    for (i in 0..lastIndex) {
        if (this[i] == value) return i
    }
    return -1
}

fun main() {
    val list = listOf(10, 2, 8, 3, 1, 5, 9)

    val index = list.search(8)

    println(index)
    require(index == 2)
}