package leetcode.`20-valid-parentheses`

// https://leetcode.com/problems/valid-parentheses/description/
fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack += char
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
        }
    }
    return true
}

fun main() {
    val validParentheses = "()[]{}"
    require(isValid(validParentheses))

    val invalidParentheses = "(]"
    require(!isValid(invalidParentheses))
}