package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.ceil
import kotlin.math.floor

val ciuraExtendedGapSequence = intArrayOf(
    954437177, 424194301, 188530801, 83791468, 37240653, 16551402, 7356179, 3269413,
    1453073, 645811, 287028, 127568, 56697, 25199, 11200, 4978, 2213, 1750, 701, 301, 132,
    57, 23, 10, 4, 1
)

fun computeCiuraExtendedGapSequence(size: Int): IntArray {
    if (size <= 1) return intArrayOf(1)

    val base = ciuraGapSequence
    if (size <= base[0]) return base

    var k = base.size
    var gap = base[0]
    do {
        gap = computeTerm(gap)
        k++
    } while (gap < size)

    val gaps = IntArray(--k)
    val extensionSize = gaps.size - base.size

    for (i in 0..gaps.lastIndex) {
        gaps[i] = if (i < extensionSize) {
            gap = computeReverseTerm(gap)
            gap
        } else base[i - extensionSize]
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
    floor(h * 2.25).toInt()

/**
 * Reverse operation to [computeTerm].
 */
private fun computeReverseTerm(h: Int) =
    ceil(h / 2.25).toInt()