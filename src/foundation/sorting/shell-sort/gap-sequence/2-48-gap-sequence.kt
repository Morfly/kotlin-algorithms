package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.ceil
import kotlin.math.pow

val `248GapSequence` = intArrayOf(
    1181377402, 476361856, 192081394, 77452175, 31230716, 12593031, 5077835, 2047515,
    825611, 332908, 134237, 54128, 21826, 8801, 3549, 1431, 577, 233, 94, 38, 16, 7, 3, 1
)

fun compute248GapSequence(size: Int): IntArray {
    if (size <= 1) return intArrayOf(1)

    var k = 1
    var gap = 1
    while (gap < size) {
        gap = computeTerm(k + 1)
        k++
    }

    val gaps = IntArray(--k)
    for (i in 0..gaps.lastIndex) {
        gaps[i] = computeTerm(k--)
    }

    return gaps
}

/**
 * General term of the gap sequence.
 *
 * @param k sequence term number (starting from 1).
 * @return k-th term of the sequence.
 */
private fun computeTerm(k: Int) =
    ceil(
        2.48.pow(k - 1)
    ).toInt()