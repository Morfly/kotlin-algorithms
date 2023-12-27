package leetcode.`49-group-anagrams`

// https://leetcode.com/problems/group-anagrams/description/
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagrams = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val sorted = str.toCharArray().sorted().joinToString("")
        if (sorted !in anagrams) {
            anagrams[sorted] = mutableListOf()
        }
        anagrams[sorted]!! += str
    }

    return anagrams.values.toList()
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    val result = groupAnagrams(strs)

    println(result)
    require(
        result == listOf(
            listOf("eat", "tea", "ate"),
            listOf("tan", "nat"),
            listOf("bat")
        )
    )
}