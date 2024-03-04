@file:Problem(companies = [Company.Meta], topics = [Topic.Recursion, Topic.Math])

package leetcode.`50-pow-x-n`

import kotlin.math.abs

@TimeComplexity("O(log n)")
@SpaceComplexity("O(log n)")
fun myPow(x: Double, n: Int): Double {

    fun pow(x: Double, n: Int): Double {
        if (x == 0.0) return 0.0
        if (n == 0) return 1.0

        val res = pow(x * x, n / 2)
        return if (n % 2 != 0) res * x else res
    }

    val res = pow(x, abs(n))
    return if (n < 0) 1 / res else res
}

fun main() {
    val result = myPow(x = 2.0, n = -1)

    println(result)
    require(result == 0.5)
}