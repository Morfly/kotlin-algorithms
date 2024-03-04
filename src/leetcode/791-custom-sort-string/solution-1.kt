@file:Problem(companies = [Company.Meta], topics = [Topic.HashTable, Topic.Sorting])

package leetcode.`791-custom-sort-string`.`solution-1`

@TimeComplexity("O(n log n)")
@SpaceComplexity("O(n)")
fun customSortString(order: String, s: String): String {
    val dict = mutableMapOf<Char, Int>()

    for (i in order.indices) {
        dict[order[i]] = i
    }

    val sorted = s.toList().sortedBy { char -> dict[char] }
    return sorted.joinToString(separator = "")
}

fun main() {
    val result = customSortString(order = "cba", s = "abcd")

    println(result)
    require(result == "dcba")
}