package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.log2

fun computeShellGapSequence(size: Int): IntArray {
    if (size <= 1) return intArrayOf(1)

    // Compute sequence size.
    val k = log2(size.toFloat()).toInt()

    val gaps = IntArray(k)

    var gap = size
    for (i in 0..gaps.lastIndex) {
        gap = computeTerm(gap)
        gaps[i] = gap
    }

    return gaps
}


/**
 * General term of the gap sequence.
 *
 * @param h previous sequence term.
 * @return next sequence term.
 */
private fun computeTerm(h: Int) = h / 2