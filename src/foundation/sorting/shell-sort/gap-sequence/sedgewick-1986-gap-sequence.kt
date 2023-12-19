package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.floor
import kotlin.math.pow

val sedgewick1986GapSequence = intArrayOf(
    1073643521, 603906049, 268386305, 150958081, 67084289, 37730305, 16764929, 9427969,
    4188161, 2354689, 1045505, 587521, 260609, 146305, 64769, 36289, 16001, 8929, 3905,
    2161, 929, 505, 209, 109, 41, 19, 5, 1
)

fun computeSedgewick1986GapSequence(arraySize: Int): IntArray {
    if (arraySize <= 1) return intArrayOf(1)

    var k = 0
    while (computeTerm(k) < arraySize) {
        k++
    }

    val gaps = IntArray(k)
    for (i in 0..gaps.lastIndex) {
        gaps[i] = computeTerm(--k)
    }
    return gaps
}


/**
 * General term of the gap sequence.
 *
 * @param k sequence term number (starting from 0).
 * @return k-th term of the sequence.
 */
private fun computeTerm(k: Int) =
    if (k % 2 == 0)
        floor(9 * (2.0.pow(k) - 2.0.pow(k * 0.5)) + 1).toInt()
    else
        floor(8 * 2.0.pow(k) - 6 * 2.0.pow((k + 1) * 0.5) + 1).toInt()