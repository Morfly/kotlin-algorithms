@file:Problem(companies = [Company.Meta], topics = [Topic.Stack])

package leetcode.`1249-minimum-remove-to-make-valid-parentheses`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun minRemoveToMakeValid(s: String): String {
    val open = ArrayDeque<Int>()
    val indicesToRemove = mutableSetOf<Int>()

    for (i in s.indices) {
        if (s[i] == '(') {
            open += i
        } else if (s[i] == ')') {
            if (open.isEmpty()) {
                indicesToRemove += i
            } else {
                open.removeLast()
            }
        }
    }
    indicesToRemove += open

    val result = StringBuilder()
    for (i in s.indices) {
        if (i !in indicesToRemove) {
            result.append(s[i])
        }
    }
    return result.toString()
}

fun main() {
    val result = minRemoveToMakeValid("lee(t(c)o)de)")

    println(result)
    require(result == "lee(t(c)o)de")
}