package foundation.sorting.`shell-sort`.`gap-sequence`

import foundation.math.`3-smooth-numbers`.count3SmoothNumbers
import kotlin.math.min
import kotlin.math.round

val prattGapSequence = intArrayOf(
    1033121304, 1019215872, 967458816, 918330048, 905969664, 859963392, 816293376,
    805306368, 774840978, 764411904, 725594112, 688747536, 679477248, 644972544, 612220032,
    603979776, 573308928, 544195584, 536870912, 516560652, 509607936, 483729408, 459165024,
    452984832, 429981696, 408146688, 402653184, 387420489, 382205952, 362797056, 344373768,
    339738624, 322486272, 306110016, 301989888, 286654464, 272097792, 268435456, 258280326,
    254803968, 241864704, 229582512, 226492416, 214990848, 204073344, 201326592, 191102976,
    181398528, 172186884, 169869312, 161243136, 153055008, 150994944, 143327232, 136048896,
    134217728, 129140163, 127401984, 120932352, 114791256, 113246208, 107495424, 102036672,
    100663296, 95551488, 90699264, 86093442, 84934656, 80621568, 76527504, 75497472,
    71663616, 68024448, 67108864, 63700992, 60466176, 57395628, 56623104, 53747712,
    51018336, 50331648, 47775744, 45349632, 43046721, 42467328, 40310784, 38263752,
    37748736, 35831808, 34012224, 33554432, 31850496, 30233088, 28697814, 28311552,
    26873856, 25509168, 25165824, 23887872, 22674816, 21233664, 20155392, 19131876,
    18874368, 17915904, 17006112, 16777216, 15925248, 15116544, 14348907, 14155776,
    13436928, 12754584, 12582912, 11943936, 11337408, 10616832, 10077696, 9565938, 9437184,
    8957952, 8503056, 8388608, 7962624, 7558272, 7077888, 6718464, 6377292, 6291456,
    5971968, 5668704, 5308416, 5038848, 4782969, 4718592, 4478976, 4251528, 4194304,
    3981312, 3779136, 3538944, 3359232, 3188646, 3145728, 2985984, 2834352, 2654208,
    2519424, 2359296, 2239488, 2125764, 2097152, 1990656, 1889568, 1769472, 1679616,
    1594323, 1572864, 1492992, 1417176, 1327104, 1259712, 1179648, 1119744, 1062882,
    1048576, 995328, 944784, 884736, 839808, 786432, 746496, 708588, 663552, 629856, 589824,
    559872, 531441, 524288, 497664, 472392, 442368, 419904, 393216, 373248, 354294, 331776,
    314928, 294912, 279936, 262144, 248832, 236196, 221184, 209952, 196608, 186624, 177147,
    165888, 157464, 147456, 139968, 131072, 124416, 118098, 110592, 104976, 98304, 93312,
    82944, 78732, 73728, 69984, 65536, 62208, 59049, 55296, 52488, 49152, 46656, 41472,
    39366, 36864, 34992, 32768, 31104, 27648, 26244, 24576, 23328, 20736, 19683, 18432,
    17496, 16384, 15552, 13824, 13122, 12288, 11664, 10368, 9216, 8748, 8192, 7776, 6912,
    6561, 6144, 5832, 5184, 4608, 4374, 4096, 3888, 3456, 3072, 2916, 2592, 2304, 2187,
    2048, 1944, 1728, 1536, 1458, 1296, 1152, 1024, 972, 864, 768, 729, 648, 576, 512, 486,
    432, 384, 324, 288, 256, 243, 216, 192, 162, 144, 128, 108, 96, 81, 72, 64, 54, 48, 36,
    32, 27, 24, 18, 16, 12, 9, 8, 6, 4, 3, 2, 1
)

fun computePrattGapSequence(size: Int): IntArray {
    if (size <= 1) return intArrayOf(1)

    var gaps = IntArray(computeSequenceSize(size))
    val lastIndex = gaps.lastIndex

    gaps[lastIndex] = 1
    var i2 = lastIndex
    var i3 = lastIndex
    var i = lastIndex - 1

    var n2: Int
    var n3: Int
    var gap: Int
    while (true) {
        n2 = 2 * gaps[i2]
        n3 = 3 * gaps[i3]
        gap = min(n2, n3)

        if (gap >= size) break

        gaps[i--] = gap
        if (n2 <= n3) i2--
        if (n2 >= n3) i3--
    }

    // Removing leading zeros, since computed sequence size is not precise and may cause extra array cells.
    if (gaps[0] == 0) gaps = gaps.removeLeadingZeros()

    return gaps
}


/**
 * Computes gap sequence size for the given array size.
 *
 * Calculates approximate number of 3-smooth numbers till [arraySize] using formula:
 * (ln(2.0 * N) * ln(3.0 * N)) / (2 * ln(2.0) * ln(3.0))
 *
 * Since calculation error may reach +-1 (or +-2 in rear cases), sequence size is rounded towards the closest
 * integer and increased by 1.
 *
 * @see [count3SmoothNumbers]
 */
private fun computeSequenceSize(arraySize: Int) =
    round(count3SmoothNumbers(N = arraySize)).toInt() + 1

/**
 * Utility function that removes leading zeros from the gap sequence array.
 *
 * @return copy of the original array without leading zeros.
 */
private fun IntArray.removeLeadingZeros(): IntArray {
    if (this[0] != 0) return this

    var zeroId = 0
    while (this[zeroId + 1] == 0) zeroId++

    return copyOfRange(zeroId + 1, size)
}