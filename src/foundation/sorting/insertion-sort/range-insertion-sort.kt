package foundation.sorting.`insertion-sort`.range

import io.morfly.algorithms.tools.isSorted

fun IntArray.insertionSort(start: Int, end: Int) {
    for (i in start + 1 until end) {
        var j = i
        val arri = this[i]
        while (j > start && arri < this[j - 1]) {
            this[j] = this[j - 1]
            j--
        }
        this[j] = arri
    }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.insertionSort(0, 5)

    println(array.joinToString())
    require(array.isSorted())
}