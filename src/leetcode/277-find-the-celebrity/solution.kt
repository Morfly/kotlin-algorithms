package leetcode.`277-find-the-celebrity`

class Solution : Relation() {

    override fun findCelebrity(n: Int): Int {
        var candidate = 0

        for (i in 1 until n) {
            if (knows(candidate, i)) {
                candidate = i
            }
        }

        for (i in 0 until n) {
            if (i == candidate) continue

            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1
            }
        }
        return candidate
    }
}

fun main() = Solution().run {

    input = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1),
    )

    val result = findCelebrity(n = input.size)

    println(result)
    require(result == 1)
}