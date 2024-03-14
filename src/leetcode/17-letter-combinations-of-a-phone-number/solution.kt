@file:Problem(companies = [Company.Meta], topics = [Topic.String, Topic.Backtracking, Topic.HashTable])

package leetcode.`17-letter-combinations-of-a-phone-number`

@TimeComplexity("O(d 4^d)")
@SpaceComplexity("O(1)")
fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val dict = mutableMapOf(
        2 to "abc",
        3 to "def",
        4 to "ghi",
        5 to "jkl",
        6 to "mno",
        7 to "pqrs",
        8 to "tuv",
        9 to "wxyz"
    )

    val combinations = mutableListOf<String>()
    fun backtrack(d: Int, lettersSoFar: String) {
        if (d > digits.lastIndex) {
            combinations += lettersSoFar
            return
        }

        val digit = digits[d].digitToInt()
        val letters = dict[digit]!!

        for (letter in letters) {
            backtrack(d + 1, lettersSoFar + letter)
        }
    }

    backtrack(d = 0, lettersSoFar = "")

    return combinations
}

fun main() {
    val input = "23"

    val result = letterCombinations(input)

    println(result)
    require(result == listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
}