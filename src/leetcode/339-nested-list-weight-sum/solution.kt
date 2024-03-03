@file:Problem(companies = [Company.Meta], topics = [Topic.DepthFirstSearch])

package leetcode.`339-nested-list-weight-sum`

fun depthSum(nestedList: List<NestedInteger>): Int {

    fun calculate(integer: NestedInteger, depth: Int): Int {
        if (integer.isInteger()) {
            return integer.getInteger()!! * depth
        }
        var res = 0
        for (nested in integer.getList()!!) {
            res += calculate(nested, depth + 1)
        }
        return res
    }

    val wrapper = NestedInteger()
    for (integer in nestedList) {
        wrapper.add(integer)
    }

    return calculate(wrapper, depth = 0)
}

fun main() {
    // [[1, 1], 2, [1, 1]]
    val input = mutableListOf(
        NestedInteger().apply {
            add(NestedInteger(1))
            add(NestedInteger(1))
        },
        NestedInteger(2),
        NestedInteger().apply {
            add(NestedInteger(1))
            add(NestedInteger(1))
        },
    )

    val result = depthSum(input)

    println(result)
    require(result == 8)
}