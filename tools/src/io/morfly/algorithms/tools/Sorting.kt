package io.morfly.algorithms.tools

fun IntArray.isSorted(): Boolean {
    for (i in 0 until size - 1) {
        if (this[i] > this[i + 1]) {
            return false
        }
    }
    return true
}