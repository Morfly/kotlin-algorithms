package leetcode.`131-palindrome-partitioning`

// https://leetcode.com/problems/palindrome-partitioning/
fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()

    fun backtrack(tmp: MutableList<String>, start: Int) {
        if (start == s.length) {
            result += tmp.toList()
        } else {
            for (i in start..s.lastIndex) {
                if (s.isPalindrome(start, i)) {
                    tmp += s.substring(start, i + 1)
                    backtrack(tmp, start = i + 1)
                    tmp.removeLast()
                }
            }
        }
    }
    backtrack(mutableListOf(), start = 0)

    return result
}

private fun String.isPalindrome(start: Int, end: Int): Boolean {
    var lo = start
    var hi = end
    while (lo < hi) {
        if (this[lo++] != this[hi--]) return false
    }
    return true
}

fun main() {
    val s = "aab"

    val result = partition(s)

    println(result)
    require(
        result == listOf(
            listOf("a", "a", "b"),
            listOf("aa", "b"),
        )
    )
}