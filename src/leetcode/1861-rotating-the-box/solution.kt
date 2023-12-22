package leetcode.`1861-rotating-the-box`

// https://leetcode.com/problems/rotating-the-box/submissions/
fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    applyGravity(box)
    return rotate(box)
}

private fun applyGravity(box: Array<CharArray>) {
    for (row in box.indices) {
        applyGravity(box[row])
    }
}

private fun applyGravity(row: CharArray) {
    var ground = row.size

    for (i in row.lastIndex downTo 0) {
        when (row[i]) {
            '*' -> ground = i
            '#' -> {
                if (ground - i > 1) {
                    row[ground - 1] = row[i]
                    row[i] = '.'
                }
                ground--
            }
        }
    }
}

private fun rotate(box: Array<CharArray>): Array<CharArray> {
    val rotated = Array(box[0].size) { CharArray(box.size) }

    for (row in box.indices) {
        for (col in box[0].indices) {
            rotated[col][box.lastIndex - row] = box[row][col]
        }
    }
    return rotated
}


fun main() {
    val box = arrayOf(
        charArrayOf('#', '#', '*', '.', '*', '.'),
        charArrayOf('#', '#', '#', '*', '.', '.'),
        charArrayOf('#', '#', '#', '.', '#', '.')
    )

    val result = rotateTheBox(box)

    println(result.joinToString(separator = "\n") { it.joinToString(separator = ", ") })
}