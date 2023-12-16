package exercises.`dynamic-programming`

fun fibonacci(n: Int): Int {
    val mem = mutableMapOf<Int, Int>()

    fun fib(n: Int): Int {
        if (n <= 0) return 0
        if (n == 1) return 1

        if (n !in mem) {
            mem[n] = fib(n - 1) + fib(n - 2)
        }
        return mem[n]!!
    }
    return fib(n)
}

fun main() {
    val result = fibonacci(10)

    println(result)
    require(result == 55)
}