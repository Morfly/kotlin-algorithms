@file:Meta(companies = [Company.Meta], topics = [Topic.TwoPointers, Topic.Sorting, Topic.Intervals])

package leetcode.`88-merge-sorted-array`

@TimeComplexity("O(m + n)")
@SpaceComplexity("O(1)")
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var p = m + n - 1

    var p1 = m - 1
    var p2 = n - 1

    while (p1 >= 0 && p2 >= 0) {
        nums1[p] =
            if (nums1[p1] > nums2[p2]) nums1[p1--]
            else nums2[p2--]
        p--
    }

    while (p1 >= 0)
        nums1[p--] = nums1[p1--]

    while (p2 >= 0)
        nums1[p--] = nums2[p2--]
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)

    merge(nums1, m = nums1.size - nums2.size, nums2, n = nums2.size)

    val result = nums1.toList()
    println(result)
    require(result == listOf(1, 2, 2, 3, 5, 6))
}