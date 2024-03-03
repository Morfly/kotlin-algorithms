package io.morfly.algorithms.tools

val IntArray.array: IntArray get() = this
val FloatArray.array: FloatArray get() = this

fun IntArray.isSorted(): Boolean {
    for (i in 0 until size - 1) {
        if (array[i] > array[i + 1]) {
            return false
        }
    }
    return true
}

fun FloatArray.isSorted(): Boolean {
    for (i in 0 until size - 1) {
        if (array[i] > array[i + 1]) {
            return false
        }
    }
    return true
}