package foundation.sorting.`insertion-sort`.sentinel

import foundation.swap
import io.morfly.algorithms.tools.isSorted

fun IntArray.insertionSort(start: Int, end: Int) {
    // Setting sentinel
    var swaps = 0
    for (i in end - 1 downTo start + 1) {
        if (this[i] < this[i - 1]) {
            swap(i, i - 1)
            swaps++
        }
    }
    if (swaps == 0) return

    // Actual insertion sort
    for (i in start + 1 until end) {
        var j = i
        val arri = this[i]
        while (arri < this[j - 1]) {
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