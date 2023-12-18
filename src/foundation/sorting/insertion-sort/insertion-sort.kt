package foundation.sorting.`insertion-sort`

fun IntArray.insertionSort() {
    for (i in 1 until size) {
        val key = this[i]
        var j = i - 1

        while (j >= 0 && this[j] > key) {
            this[j + 1] = this[j]
            j--
        }
        this[j + 1] = key
    }
}

fun main() {
    val array = intArrayOf(9, 5, 1, 4, 3)

    array.insertionSort()

    println(array.joinToString())
}