@file:Problem(companies = [Company.Meta], topics = [Topic.String, Topic.Graph, Topic.TopologicalSort])

package leetcode.`269-alien-dictionary`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun alienOrder(words: Array<String>): String {
    if (words.isEmpty()) return ""
    if (words.size == 1) return words.first().toSet().joinToString(separator = "")

    val dict = mutableMapOf<Char, MutableList<Char>>()
    for (i in 1..words.lastIndex) {
        val word1 = words[i - 1]
        val word2 = words[i]
        if (word1 == word2) continue

        var p = 0
        while (p < word1.length && p < word2.length && word1[p] == word2[p]) {
            p++
        }
        if (p < word1.length && p < word2.length) {
            dict.getOrPut(word1[p], ::mutableListOf) += word2[p]
        } else if (word1.length > word2.length) {
            return ""
        }
    }
    for (word in words) {
        for (char in word) {
            if (char !in dict) {
                dict[char] = mutableListOf()
            }
        }
    }

    val explored = mutableSetOf<Char>()
    val result = linkedSetOf<Char>()
    var valid = true

    fun topSort(char: Char) {
        explored += char
        for (successor in dict[char].orEmpty()) {
            if (successor !in explored) {
                topSort(successor)
            } else if (successor !in result) {
                valid = false
                return
            }
        }
        result += char
    }

    for ((char, _) in dict) {
        if (char !in explored) {
            topSort(char)
            if (!valid) return ""
        }
    }
    return result.reversed().joinToString(separator = "")
}

fun main() {
    val input = arrayOf("wrt", "wrf", "er", "ett", "rftt")

    val result = alienOrder(input)

    println(result)
    require(result == "wertf")
}