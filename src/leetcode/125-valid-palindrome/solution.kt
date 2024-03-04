@file:Problem(companies = [Company.Meta], topics = [Topic.TwoPointers, Topic.String])

package leetcode.`125-valid-palindrome`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.lastIndex

    while (start <= end) {
        when {
            !s[start].isLetterOrDigit() -> start++

            !s[end].isLetterOrDigit() -> end--

            s[start].lowercase() == s[end].lowercase() -> {
                start++
                end--
            }

            else -> return false
        }
    }
    return true
}

fun main() {
    val input = "A man, a plan, a canal: Panama"

    val result = isPalindrome(input)

    println(result)
    require(result)
}