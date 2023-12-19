package foundation.sorting.`bubble-sort`

fun IntArray.bubbleSort() {
    for (i in 0..<lastIndex) {
        for (j in 0..<lastIndex - i) {
            if (this[j] > this[j + 1]) {
                this[j] = this[j + 1].also { this[j + 1] = this[j] }
            }
        }
    }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    array.bubbleSort()

    println(array.joinToString())
    require(array.toList() == listOf(11, 12, 22, 25, 34, 64, 90))
}