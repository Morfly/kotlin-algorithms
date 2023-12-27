package leetcode.`62-unique-paths`

fun uniquePaths(m: Int, n: Int): Int {
    val mem = Array(m) { IntArray(n) { -1 } }

    fun uniquePaths(row: Int, col: Int): Int {
        if (row < 0 || col < 0) return 0
        if (row == 0 || col == 0) return 1
        if (mem[row][col] == -1) {
            mem[row][col] = uniquePaths(row - 1, col) + uniquePaths(row, col - 1)
        }
        return mem[row][col]
    }

    return uniquePaths(row = m - 1, col = n - 1)
}

fun main() {
    val result = uniquePaths(3, 7)

    println(result)
    require(result == 28)
}