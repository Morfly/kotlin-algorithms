@file:Problem(companies = [Company.Meta], topics = [Topic.String, Topic.HashTable])

package exercises.`dynamic-programming`.`min-stickers`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun minStickers(sticker: String, word: String): Int {
    val stickerDict = mutableMapOf<Char, Int>()
    for (c in sticker) {
        stickerDict[c] = stickerDict.getOrDefault(c, 0) + 1
    }

    val wordChars = mutableMapOf<Char, Int>()
    for (c in word) {
        wordChars[c] = wordChars.getOrDefault(c, 0) + 1
    }

    var max = -1
    for ((char, count) in wordChars) {
        if (char !in stickerDict) return -1

        val countPerSticker = stickerDict[char]!!
        val stickers = count / countPerSticker + if (count % countPerSticker != 0) 1 else 0
        max = maxOf(max, stickers)
    }

    return max
}

// https://leetcode.com/discuss/interview-question/4835013/Meta-Minimum-Stickers-Required
fun main() {
    val result = minStickers(sticker = "ban", word = "banana")

    println(result)
    require(result == 3)
}