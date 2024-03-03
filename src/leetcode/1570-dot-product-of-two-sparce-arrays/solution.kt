@file:Problem(companies = [Company.Meta])

package leetcode.`1570-dot-product-of-two-sparce-arrays`

typealias Index = Int

// p and q are the numbers of non-zero numbers in the respective vectors.
@TimeComplexity("O(n)")
@SpaceComplexity("O(p + q)")
class SparseVector(nums: IntArray) {
    private val values = mutableMapOf<Index, Int>()

    init {
        for (i in nums.indices) {
            if (nums[i] != 0)
                values[i] = nums[i]
        }
    }

    // Only this function.
    // k is the smaller number of non-zero numbers among two vectors. Only this function.
    @TimeComplexity("O(k)")
    @SpaceComplexity("O(1)")
    fun dotProduct(vec: SparseVector): Int {
        if (vec.values.size < this.values.size) return vec.dotProduct(this)

        var res = 0
        for (i in this.values.keys) {
            if (i in vec.values) {
                res += this.values[i]!! * vec.values[i]!!
            }
        }
        return res
    }
}

fun main() {
    val v1 = SparseVector(intArrayOf(1, 0, 0, 2, 3))
    val v2 = SparseVector(intArrayOf(0, 3, 0, 4, 0))

    val result = v1.dotProduct(v2)

    println(result)
    require(result == 8)
}