package foundation

// TODO move to specific algorithms where it's used
fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)

    array.swap(i = 0, j = 3)

    val result = array.toList()

    println(result)
    require(result == listOf(4, 2, 3, 1, 5))
}