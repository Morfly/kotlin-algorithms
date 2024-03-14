@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.BinarySearch])

package leetcode.`1539-kth-missing-positive-number`

@TimeComplexity("O(log n)")
@SpaceComplexity("O(1)")
fun findKthPositive(arr: IntArray, k: Int): Int {
    var start = 0
    var end = arr.lastIndex

    while (start <= end) {
        val mid = (start + end) / 2
        val missing = arr[mid] - mid - 1

        if (missing < k) start = mid + 1
        else end = mid - 1
    }
    return start + k
}

fun main() {
    val input = intArrayOf(2, 3, 4, 7, 11)

    val result = findKthPositive(input, k = 5)

    println(result)
    require(result == 9)
}