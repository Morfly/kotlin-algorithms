package foundation.sorting.`quick-sort`.partition

import foundation.swap

fun IntArray.lomutoPartition(start: Int, end: Int): Int {
    val pivot = this[end - 1]
    var i = start - 1
    for (j in start until end) {
        if (this[j] < pivot) {
            i++
            swap(i, j)
        }
    }
    swap(i, end - 1)
    return i
}