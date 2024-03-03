package foundation.sorting.`quick-sort`.partition.hoare

import io.morfly.algorithms.tools.array

fun IntArray.hoarePartition(start: Int, end: Int): Int {
    val pivotPosition = (start + end - 1) / 2
    swap(pivotPosition, start)

    val pivot = array[start]
    var i = start
    var j = end
    while (true) {
        do i++
        while (i < end && array[i] < pivot)

        do j--
        while (array[j] > pivot)

        if (i >= j) break
        swap(i, j)
    }
    swap(start, j)
    return j
}

private fun IntArray.swap(i: Int, j: Int) {
    array[i] = array[j].also { array[j] = array[i] }
}