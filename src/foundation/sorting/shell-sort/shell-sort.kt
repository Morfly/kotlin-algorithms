package foundation.sorting.`shell-sort`

import foundation.sorting.`shell-sort`.`gap-sequence`.ciuraExtendedGapSequence
import io.morfly.algorithms.tools.isSorted

fun IntArray.shellSort() {
    shellSort(ciuraExtendedGapSequence)
}

fun IntArray.shellSort(gaps: IntArray) {
    for (gap in gaps) {
        for (i in gap..lastIndex) {
            var j = i
            val arri = this[i]
            while (j >= gap && arri < this[j - gap]) {
                this[j] = this[j - gap]
                j -= gap
            }
            this[j] = arri
        }
    }
}

fun main() {
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    array.shellSort()

    println(array.joinToString())
    require(array.isSorted())
}