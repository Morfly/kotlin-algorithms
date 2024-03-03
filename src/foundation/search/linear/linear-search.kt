package foundation.search.linear

@TimeComplexity("O(log n)")
@SpaceComplexity("O(1)")
fun IntArray.search(value: Int): Int {
    for (i in 0..lastIndex) {
        if (this[i] == value) return i
    }
    return -1
}

fun main() {
    val list = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    val index = list.search(8)

    println(index)
    require(index == 2)
}