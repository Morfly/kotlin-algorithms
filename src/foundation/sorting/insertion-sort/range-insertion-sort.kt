package foundation.sorting.`insertion-sort`.range

import io.morfly.algorithms.tools.*

fun IntArray.insertionSort(start: Int, end: Int) {
    for (i in start + 1 until end) {
        var j = i
        val arri = array[i]
        while (j > start && arri < array[j - 1]) {
            array[j] = array[j - 1]
            j--
        }
        array[j] = arri
    }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.insertionSort(0, 5)

    println(array.joinToString())
    require(array.isSorted())
}