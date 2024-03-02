package leetcode.`346-moving-average-from-data-stream`

import java.text.DecimalFormat

private val df = DecimalFormat("#.#####")

fun Double.format(): Double {
    return df.format(this).toDouble()
}