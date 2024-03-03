@file:Problem(companies = [Company.Meta])

package leetcode.`408-valid-word-abbreviation`

fun validWordAbbreviation(word: String, abbr: String): Boolean {
    var w = 0
    var a = 0

    while (w < word.length && a < abbr.length) {
        if (abbr[a].isDigit()) {
            if (abbr[a] == '0') return false

            val start = a
            while (a < abbr.length && abbr[a].isDigit()) {
                a++
            }
            w += abbr.substring(start, a).toInt()

        } else if (word[w] == abbr[a]) {
            w++
            a++
        } else {
            return false
        }
    }

    return w == word.length && a == abbr.length
}

fun main() {
    val result = validWordAbbreviation(
        word = "internationalization",
        abbr = "i12iz4n"
    )

    println(result)
    require(result)
}