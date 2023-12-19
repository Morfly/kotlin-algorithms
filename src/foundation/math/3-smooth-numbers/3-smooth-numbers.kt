package foundation.math.`3-smooth-numbers`

import kotlin.math.ln
import kotlin.math.min
import kotlin.math.round


/**
 * Calculates number of 3-smooth numbers till [N].
 *
 * An alternative formula is also applicable:
 * (ln(N) / ln(2.0) + 1) * (ln(N) / ln(3.0) + 1) * 0.5
 *
 * Note: the result of the function is approximate and may differ from the correct one by +-1 (or +-2 in rear cases).
 *
 * @see [Ramanujan's First Letter to Hardy and the Number of 3-Smooth Integers](https://math.stackexchange.com/questions/15966/ramanujans-first-letter-to-hardy-and-the-number-of-3-smooth-integers)
 * @see [3-Smooth Representations of Integers](https://www.jstor.org/stable/2589404)
 */
fun count3SmoothNumbers(N: Int) =
    (ln(2.0 * N) * ln(3.0 * N)) / (2 * ln(2.0) * ln(3.0))


fun list3SmoothNumbers(N: Int): IntArray {
    if (N <= 0) return IntArray(size = 0)

    val sequenceSize = round(count3SmoothNumbers(N)).toInt() + 1

    var numbers = IntArray(sequenceSize)
    numbers[0] = 1
    var i2 = 0
    var i3 = 0
    var i = 1

    var n2: Int
    var n3: Int
    var number: Int
    while (true) {
        n2 = 2 * numbers[i2]
        n3 = 3 * numbers[i3]
        number = min(n2, n3)

        if (number >= N) break
        numbers[i++] = number

        if (n2 <= n3) i2++
        if (n2 >= n3) i3++
    }

    if (numbers.last() == 0) numbers = numbers.removeTrailingZeros()

    return numbers
}


/**
 * Utility function that removes trailing zeros from the gap sequence array.
 *
 * @return copy of the original array without trailing zeros.
 */
private fun IntArray.removeTrailingZeros(): IntArray {
    if (last() != 0) return this

    var zeroId = lastIndex
    while (this[lastIndex - 1] == 0) zeroId--

    return copyOfRange(0, zeroId)
}