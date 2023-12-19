package foundation.sorting.`shell-sort`.`gap-sequence`

val hibardGapSequence = intArrayOf(
    1073741823, 536870911, 268435455, 134217727, 67108863, 33554431, 16777215, 8388607,
    4194303, 2097151, 1048575, 524287, 262143, 131071, 65535, 32767, 16383, 8191, 4095,
    2047, 1023, 511, 255, 127, 63, 31, 15, 7, 3, 1
)

fun computeHibardGapSequence(size: Int): IntArray {
    if (size <= 1) return intArrayOf(1)

    var k = 1
    var gap = 1
    // Determine gap sequence size and it's largest element.
    while (gap < size) {
        gap = computeTerm(gap)
        k++
    }

    val gaps = IntArray(--k)
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
private fun computeTerm(h: Int) = 2 * h + 1

/**
 * Reverse operation to [computeTerm].
 */
private fun computeReverseTerm(h: Int) = h / 2