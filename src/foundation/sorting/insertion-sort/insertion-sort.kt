package foundation.sorting.`insertion-sort`

import io.morfly.algorithms.tools.isSorted

fun IntArray.insertionSort() {
    for (i in 1..lastIndex) {
        var j = i
        val arri = this[i]
        while (j > 0 && arri < this[j - 1]) {
            this[j] = this[j - 1]
            j--
        }
        this[j] = arri
    }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.insertionSort()

    println(array.joinToString())
    require(array.isSorted())
}