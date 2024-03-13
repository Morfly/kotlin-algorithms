@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.HashTable, Topic.Memoization])

package leetcode.`139-word-break`

@TimeComplexity("O(m n^2)")
@SpaceComplexity("O(n)")
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val cache = BooleanArray(s.length) { true }

    fun find(i: Int): Boolean {
        if (i == s.length) return true
        if (!cache[i]) return false

        for (word in wordDict) {
            if (!compare(s, i, word)) continue

            if (find(i + word.length)) return true
        }
        cache[i] = false
        return false
    }
    return find(i = 0)
}

fun compare(s: String, i: Int, word: String): Boolean {
    for (c in word.indices) {
        if (i + c > s.lastIndex) return false
        if (s[i + c] != word[c]) return false
    }
    return true
}

fun main() {
    val input = listOf("apple", "pen")

    val result = wordBreak(s = "applepenapple", input)

    println(result)
    require(result)
}