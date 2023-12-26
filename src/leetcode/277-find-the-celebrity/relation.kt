package leetcode.`277-find-the-celebrity`

abstract class Relation {

    var input = arrayOf<IntArray>()

    fun knows(a: Int, b: Int): Boolean {
        return input[a][b] == 1
    }

    abstract fun findCelebrity(n: Int): Int
}