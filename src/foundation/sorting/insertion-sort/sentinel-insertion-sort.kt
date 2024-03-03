package foundation.sorting.`insertion-sort`.sentinel

import io.morfly.algorithms.tools.*

fun IntArray.insertionSort(start: Int, end: Int) {
    // Setting sentinel
    var swaps = 0
    for (i in end - 1 downTo start + 1) {
        if (array[i] < array[i - 1]) {
            swap(i, i - 1)
            swaps++
        }
    }
    if (swaps == 0) return

    // Actual insertion sort
    for (i in start + 2 until end) {
        var j = i
        val arri = array[i]
        while (arri < array[j - 1]) {
            array[j] = array[j - 1]
            j--
        }
        array[j] = arri
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    array[i] = array[j].also { array[j] = array[i] }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.insertionSort(0, 5)

    println(array.joinToString())
    require(array.isSorted())
}