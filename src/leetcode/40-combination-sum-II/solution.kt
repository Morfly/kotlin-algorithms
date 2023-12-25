package leetcode.`40-combination-sum-II`

// https://leetcode.com/problems/combination-sum-ii/
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    candidates.sort()

    fun backtrack(tmp: MutableList<Int>, remain: Int, start: Int) {
        when {
            remain < 0 -> return
            remain == 0 -> result += tmp.toList()
            else -> {
                for (i in start..candidates.lastIndex) {
                    if (i > start && candidates[i] == candidates[i - 1]) continue
                    tmp += candidates[i]
                    backtrack(tmp, remain = remain - candidates[i], start = i + 1)
                    tmp.removeLast()
                }
            }
        }
    }
    backtrack(mutableListOf(), remain = target, start = 0)

    return result
}

fun main() {
    val candidates = intArrayOf(2, 5, 2, 1, 2)

    val result = combinationSum2(candidates, target = 5)

    println(result)
    require(
        result == listOf(
            listOf(1, 2, 2),
            listOf(5),
        )
    )
}