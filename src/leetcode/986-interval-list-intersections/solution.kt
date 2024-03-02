@file:Meta(companies = [Company.Meta], topics = [Topic.TwoPointers, Topic.Intervals])

package leetcode.`986-interval-list-intersections`

@TimeComplexity("(O(n + m)", Comment("n and m are lengths of corresponding lists."))
@SpaceComplexity("O(k)", Comment("k is a number of intersections."))
fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()

    fun append(interval1: IntArray, interval2: IntArray) {
        if (interval1[1] < interval2[0]) return

        val start = maxOf(interval1[0], interval2[0])
        val end = minOf(interval1[1], interval2[1])
        result += intArrayOf(start, end)
    }

    var i1 = 0
    var i2 = 0
    while (i1 < firstList.size && i2 < secondList.size) {
        val interval1 = firstList[i1]
        val interval2 = secondList[i2]

        if (interval1[0] < interval2[0]) append(interval1, interval2)
        else append(interval2, interval1)

        if (interval1[1] < interval2[1]) i1++
        else i2++
    }

    return result.toTypedArray()
}

fun main() {
    val list1 = arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25))
    val list2 = arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))

    val result = intervalIntersection(list1, list2).map(IntArray::toList)

    println(result)
    require(result == listOf(listOf(1, 2), listOf(5, 5), listOf(8, 10), listOf(15, 23), listOf(24, 24), listOf(25, 25)))
}