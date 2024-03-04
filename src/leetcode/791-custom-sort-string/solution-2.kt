@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Sorting])

package leetcode.`791-custom-sort-string`.`solution-2`

@TimeComplexity("O(n log n)")
@SpaceComplexity("O(n)")
fun customSortString(order: String, s: String): String {
    val dict = IntArray(26)

    for (i in order.indices) {
        dict[order[i] - 'a'] = i
    }

    val sorted = s.toList().sortedBy { char -> dict[char - 'a'] }
    return sorted.joinToString(separator = "")
}

fun main() {
    val result = customSortString(order = "cba", s = "abcd")

    println(result)
    require(result == "cdba")
}