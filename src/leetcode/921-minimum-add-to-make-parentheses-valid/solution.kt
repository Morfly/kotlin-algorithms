@file:Problem(companies = [Company.Meta], topics = [Topic.String, Topic.Stack])

package leetcode.`921-minimum-add-to-make-parentheses-valid`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun minAddToMakeValid(s: String): Int {
    var open = 0
    var close = 0

    for (char in s) {
        when (char) {
            '(' -> open++
            ')' -> {
                if (open > 0) open-- else close++
            }
        }
    }
    return open + close
}

fun main() {
    val input = "()))(("

    val result = minAddToMakeValid(input)

    println(result)
    require(result == 4)
}