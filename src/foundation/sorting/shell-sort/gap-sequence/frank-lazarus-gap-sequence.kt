package foundation.sorting.`shell-sort`.`gap-sequence`

import kotlin.math.floor
import kotlin.math.pow

fun computeFrankLazarusGapSequence(size: Int): IntArray {
    var k = 1
    // Determine gap sequence size and it's largest element.
    while (computeTerm(k, size) != 1) {
        k++
    }

    val gaps = IntArray(k)
    k = 1
    for (i in 0..gaps.lastIndex) {
        gaps[i] = computeTerm(k++, size)
    }

    return gaps
}

/**
 * General term of the gap sequence.
 *
 * @param N array size.
 * @param k sequence term number (starting from 1).
 * @return k-th term of the sequence.
 */
private fun computeTerm(k: Int, N: Int): Int {
    val gap = 2 * floor(N / 2.0.pow(k + 1)) + 1
    return gap.toInt()
}
