package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.floor
import kotlin.math.max


fun computeGonetBaezaYatesGapSequence(size: Int): IntArray {
    var k = 1
    var gap = computeTerm(size)
    while (gap > 1) {
        gap = computeTerm(gap)
        k++
    }

    val gaps = IntArray(k)
    gap = size
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
private fun computeTerm(h: Int) =
    floor(
        max(a = (5 * h) / 11.0, b = 1.0)
    ).toInt()