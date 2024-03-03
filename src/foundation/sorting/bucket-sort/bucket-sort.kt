@file:SortingAlgorithm(
    Stable(true, comment = "Only if the underlying algorithm for sorting buckets is stable."),
    InPlace(false), Comparative(false), Recursive(false),
    "Efficient for sorting floating point values that are uniformly distributed across a known range that is not excessively large."
)

package foundation.sorting.`bucket-sort`

import io.morfly.algorithms.tools.*

@TimeComplexities(
    worst = Worst("O(n^2)", comment = "All elements are in 1 bucket, depends on a sorting algorithm used for buckets."),
    average = Average("O(n + k)", comment = "n is the array size, k is the number of buckets."),
    best = Best("O(n)", comment = "Each bucket has only 1 element.")
)
@SpaceComplexity("O(n + k)")
fun FloatArray.bucketSort() {
    val buckets = Array(size) { mutableListOf<Float>() }

    for (element in array) {
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

// https://youtu.be/ROnYubH_spM?si=mpQL_nAGEZqG_3tA
fun main() {
    val array = floatArrayOf(0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f)

    array.bucketSort()

    println(array.joinToString())
    require(array.isSorted())
}
