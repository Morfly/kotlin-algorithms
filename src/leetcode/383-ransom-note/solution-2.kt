@file:Problem(companies = [Company.Meta], topics = [Topic.String, Topic.Array])

package leetcode.`383-ransom-note`.`solution-2`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val dict = IntArray(26)
    for (c in magazine) {
        dict[c - 'a']++
    }

    for (c in ransomNote) {
        dict[c - 'a']--
        if (dict[c - 'a'] < 0) return false
    }
    return true
}

fun main() {
    val result = canConstruct(ransomNote = "aa", magazine = "aab")

    println(result)
    require(result)
}