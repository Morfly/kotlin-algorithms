@file:Problem(
    companies = [Company.Meta], topics = [Topic.Array, Topic.Matrix, Topic.Backtracking, Topic.String],
    comment = "*"
)

package leetcode.`79-word-search`

@TimeComplexity("O(n * m)")
@SpaceComplexity("O(1)")
fun exist(board: Array<CharArray>, word: String): Boolean {
    val directions = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

    fun traverse(row: Int, col: Int, i: Int): Boolean {
        if (row !in 0..board.lastIndex) return false
        if (col !in 0..board[0].lastIndex) return false
        if (board[row][col] == '0') return false
        if (i < word.length && board[row][col] != word[i]) return false

        val letter = board[row][col]
        board[row][col] = '0'

        if (i == word.lastIndex) return true

        for ((dirRow, dirCol) in directions) {
            val result = traverse(row + dirRow, col + dirCol, i + 1)
            if (result) return true
        }

        board[row][col] = letter
        return false
    }

    for (row in board.indices) {
        for (col in board[0].indices) {
            val result = traverse(row, col, i = 0)
            if (result) return true
        }
    }
    return false
}

fun main() {
    val input = arrayOf(
        charArrayOf('C', 'A', 'A'),
        charArrayOf('A', 'A', 'A'),
        charArrayOf('B', 'C', 'D')
    )

    val result = exist(input, word = "AAB")

    println(result)
    require(!result)
}