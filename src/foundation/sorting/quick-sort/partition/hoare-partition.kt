package foundation.sorting.`quick-sort`.partition

import foundation.swap

fun IntArray.hoarePartition(start: Int, end: Int): Int {
    val pivotPosition = (start + end - 1) / 2
    swap(pivotPosition, start)

    val pivot = this[start]
    var i = start
    var j = end
    while (true) {
        do i++
        while (i < end && this[i] < pivot)

        do j--
        while (this[j] > pivot)

        if (i >= j) break
        swap(i, j)
    }
    swap(start, j)
    return j
}