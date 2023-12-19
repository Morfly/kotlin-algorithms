package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.ceil
import kotlin.math.pow

val tokudaGapSequence = intArrayOf(
    1147718700, 510097200, 226709866, 100759940, 44782196, 19903198, 8845866, 3931496,
    1747331, 776591, 345152, 153401, 68178, 30301, 13467, 5985, 2660, 1182, 525, 233, 103,
    46, 20, 9, 4, 1
)

fun computeTokudaGapSequence(arraySize: Int): IntArray {
    if (arraySize <= 1) return intArrayOf(1)

    var k = 1
    var gap = 1
    while (gap < arraySize) {
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
        (9.0.pow(k) - 4.0.pow(k)) / (5 * 4.0.pow(k - 1))
    ).toInt()