@file:SortingAlgorithm(stable.no, `in-place`.yes, comparative.yes, recursive.no)

package foundation.sorting.`shell-sort`

import foundation.sorting.`shell-sort`.`gap-sequence`.ciuraGapSequence
import io.morfly.algorithms.tools.*

@TimeComplexity("Depends on gap sequence.")
@SpaceComplexity("O(1)")
fun IntArray.shellSort() {
    shellSort(ciuraGapSequence)
}

fun IntArray.shellSort(gapSequence: IntArray) {
    for (gap in gapSequence) {
        for (i in gap..array.lastIndex) {
            var j = i
            val arri = array[i]
            while (j >= gap && arri < array[j - gap]) {
                array[j] = array[j - gap]
                j -= gap
            }
            array[j] = arri
        }
    }
}

fun main() {
    val array = intArrayOf(10, 2, 8, 3, 1, 5, 9)

    array.shellSort()

    println(array.joinToString())
    require(array.isSorted())
}