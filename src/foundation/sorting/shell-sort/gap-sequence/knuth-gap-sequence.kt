package foundation.sorting.`shell-sort`.`gap-sequence`

val knuthGapSequence = intArrayOf(
    581130733, 193710244, 64570081, 21523360, 7174453, 2391484, 797161, 265720, 88573,
    29524, 9841, 3280, 1093, 364, 121, 40, 13, 4, 1
)

fun computeKnuthGapSequence(size: Int): IntArray {
    var k = 1
    var gap = 1
    val maxGap = computeMaxTerm(size)
    while (gap <= maxGap) {
        gap = computeTerm(gap)
        k++
    }

    if (--k <= 1) return intArrayOf(1)

    val gaps = IntArray(k)
    for (i in 0..gaps.lastIndex) {
        gap = computeReverseTerm(gap)
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
private fun computeTerm(h: Int) = 3 * h + 1

/**
 * Reverse operation to [computeTerm].
 */
private fun computeReverseTerm(h: Int) = h / 3

/**
 * Computes max term of the gap sequence.
 * Max term should not be greater than N / 3, where N - array size.
 *
 * @param N array size
 */
private fun computeMaxTerm(N: Int) = N / 3.0