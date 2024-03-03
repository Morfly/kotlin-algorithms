@file:Problem(topics = [Topic.BitManipulation])

package leetcode.`191-number-of-1-bits`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun hammingWeight(n: Int): Int {
    var bits = 0
    var a = n
    while (a != 0) {
        if (a and 1 == 1) bits++
        a = a ushr 1
    }
    return bits
}

fun main() {
    val input = 0b01000000000000000000000000001011

    val result = hammingWeight(input)

    println(result)
    require(result == 4)
}