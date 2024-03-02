package foundation.sorting.`bucket-sort`

import io.morfly.algorithms.tools.isSorted

@TimeComplexities(
    Worst("O(n^2)", Comment("all elements are in a single bucket.")),
    Average("O(n + k)", Comment("n is an array size, k is a bucket size.")),
)
@SpaceComplexity("O(n + k)")
fun FloatArray.bucketSort() {
    val buckets = Array(size) { mutableListOf<Float>() }

    for (element in this) {
        val bucketIndex = (element * size).toInt()
        buckets[bucketIndex] += element
    }

    for (bucket in buckets) {
        bucket.sort()
    }

    var index = 0
    for (bucket in buckets) {
        for (element in bucket) {
            this[index++] = element
        }
    }
}

fun main() {
    val array = floatArrayOf(0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f)

    array.bucketSort()

    println(array.joinToString())
    require(array.isSorted())
}
