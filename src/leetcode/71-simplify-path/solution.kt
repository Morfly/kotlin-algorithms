@file:Problem(companies = [Company.Meta], topics = [Topic.Stack, Topic.String])

package leetcode.`71-simplify-path`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun simplifyPath(path: String): String {
    val stack = ArrayDeque<String>()
    val components = path.split('/').filter { it.isNotEmpty() }

    for (comp in components) {
        when (comp) {
            ".." -> if (stack.isNotEmpty()) stack.removeLast()
            "." -> {}
            else -> stack += comp
        }
    }
    return stack.joinToString(prefix = "/", separator = "/")
}

fun main() {
    val input = "/a/./b/../../c/"

    val result = simplifyPath(input)

    println(result)
    require(result == "/c")
}