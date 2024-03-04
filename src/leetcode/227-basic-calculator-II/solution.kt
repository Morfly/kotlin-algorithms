@file:Problem(companies = [Company.Meta], topics = [Topic.Math, Topic.Stack, Topic.String])

package leetcode.`227-basic-calculator-II`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun calculate(s: String): Int {
    val stack = ArrayDeque<Int>()
    var operation = '+'

    var p = 0
    while (p < s.length) {
        when (s[p]) {
            '+', '-', '/', '*' -> operation = s[p++]
            ' ' -> p++
            else -> {
                val start = p
                while (p < s.length && s[p].isDigit()) {
                    p++
                }
                val number = s.substring(start, p).toInt()

                when (operation) {
                    '+' -> stack += number
                    '-' -> stack += number * -1
                    '*' -> stack += stack.removeLast() * number
                    '/' -> stack += stack.removeLast() / number
                }
            }
        }
    }
    return stack.sum()
}

fun main() {
    val input = " 3+5 / 2 "

    val result = calculate(input)

    println(result)
    require(result == 5)
}