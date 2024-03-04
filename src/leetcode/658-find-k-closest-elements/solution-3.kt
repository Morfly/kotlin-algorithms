@file:Problem(companies = [Company.Meta], topics = [Topic.BinarySearch, Topic.SlidingWindow])

package leetcode.`658-find-k-closest-elements`.`solution-3`

@TimeComplexity("O(log(n - k) + k)")
@SpaceComplexity("O(k)")
fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var start = 0
    var end = arr.size - k

    while (start < end) {
        val mid = (start + end) / 2
        if (arr[mid + k] - x < x - arr[mid]) {
            start = mid + 1
        } else {
            end = mid
        }
    }

    val result = mutableListOf<Int>()
    for (i in start..<end + k)
        result += arr[i]

    return result
}

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)

    val result = findClosestElements(input, k = 4, x = 3)

    println(result)
    require(result == listOf(1, 2, 3, 4))
}