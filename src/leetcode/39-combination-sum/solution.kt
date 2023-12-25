package leetcode.`39-combination-sum`

// https://leetcode.com/problems/combination-sum/
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    candidates.sort()

    fun backtrack(tmp: MutableList<Int>, remain: Int, start: Int) {
        when {
            remain < 0 -> return
            remain == 0 -> result += tmp.toList()
            else -> {
                for (i in start..candidates.lastIndex) {
                    tmp += candidates[i]
                    backtrack(tmp, remain = remain - candidates[i], start = i)
                    tmp.removeLast()
                }
            }
        }
    }
    backtrack(mutableListOf(), remain = target, start = 0)

    return result
}

fun main() {
    val candidates = intArrayOf(2, 3, 5)

    val result = combinationSum(candidates, target = 8)

    println(result)
    require(
        result == listOf(
            listOf(2, 2, 2, 2),
            listOf(2, 3, 3),
            listOf(3, 5),
        )
    )
}