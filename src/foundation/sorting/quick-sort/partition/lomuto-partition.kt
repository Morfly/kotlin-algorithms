package foundation.sorting.`quick-sort`.partition.lomuto

import io.morfly.algorithms.tools.array

fun IntArray.lomutoPartition(start: Int, end: Int): Int {
    val pivot = array[end - 1]
    var i = start - 1
    for (j in start until end) {
        if (array[j] < pivot) {
            i++
            swap(i, j)
        }
    }
    swap(i, end - 1)
    return i
}

private fun IntArray.swap(i: Int, j: Int) {
    array[i] = array[j].also { array[j] = array[i] }
}
