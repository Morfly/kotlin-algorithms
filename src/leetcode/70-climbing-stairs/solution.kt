package leetcode.`70-climbing-stairs`

fun climbStairs(n: Int): Int {
    val mem = IntArray(n + 1) { -1 }
    mem[0] = 0
    mem[1] = 1
    mem[2] = 2

    for (i in 3..n) {
        mem[i] = mem[i - 1] + mem[i - 2]
    }
    return mem[n]
}

fun main() {
    val result = climbStairs(3)

    require(result == 3)
}