@file:Problem(companies = [Company.Meta], topics = [Topic.String, Topic.HashTable])

package leetcode.`383-ransom-note`.`solution-1`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val dict = mutableMapOf<Char, Int>()
    for (c in magazine) {
        dict[c] = dict.getOrDefault(c, 0) + 1
    }

    for (c in ransomNote) {
        if (c !in dict) return false

        dict[c] = dict[c]!! - 1
        if (dict[c]!! < 0) return false
    }
    return true
}

fun main() {
    val result = canConstruct(ransomNote = "aa", magazine = "aab")

    println(result)
    require(result)
}