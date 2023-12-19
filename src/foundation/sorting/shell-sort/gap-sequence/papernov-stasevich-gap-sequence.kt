package foundation.sorting.`shell-sort`.`gap-sequence`

val papernovStasevichGapSequence = intArrayOf(
    536870913, 268435457, 134217729, 67108865, 33554433, 16777217, 8388609, 4194305,
    2097153, 1048577, 524289, 262145, 131073, 65537, 32769, 16385, 8193, 4097, 2049, 1025,
    513, 257, 129, 65, 33, 17, 9, 5, 3, 1
)

fun computePapernovStasevichGapSequence(size: Int): IntArray {

    // Computation starts from 2nd term. 1st term which equals to 1 should be added manually.
    var k = 2
    // Second term of the sequence is always equals to 3.
    var gap = 3
    // Determine gap sequence size and it's largest element.
    while (gap < size) {
        gap = computeTerm(gap)
        k++
    }

    val gaps = IntArray(--k)
    for (i in 0..gaps.lastIndex) {
        // General term covers all terms except 1, which should be manually added to the sequence.
        gaps[i] = if (i == gaps.lastIndex) 1
        else {
            gap = computeReverseTerm(gap)
            gap
        }
    }

    return gaps
}


/**
 * General term of the gap sequence.
 *
 * @param h previous sequence term.
 * @return next sequence term.
 */
private fun computeTerm(h: Int) = 2 * h - 1

/**
 * Reverse operation to [computeTerm].
 */
private fun computeReverseTerm(h: Int) = h / 2 + 1