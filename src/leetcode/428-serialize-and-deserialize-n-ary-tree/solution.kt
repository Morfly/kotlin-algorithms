@file:Problem(companies = [Company.Meta], topics = [Topic.Tree, Topic.String, Topic.DepthFirstSearch])

package leetcode.`428-serialize-and-deserialize-n-ary-tree`

class Codec {

    // n - number of tree nodes, h - tree height
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    fun serialize(root: Node?): String {
        val builder = StringBuilder()
        serialize(root, builder)
        return builder.toString()
    }

    private fun serialize(node: Node?, builder: StringBuilder) {
        if (node == null) return

        with(builder) {
            if (builder.isNotEmpty()) append(' ')
            append('[')
            append(node.`val`)
            for (child in node.children) {
                serialize(child, builder)
            }
            append(']')
        }
    }

    // n - number of tree nodes, h - tree height
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    fun deserialize(data: String): Node? {
        if (data.isEmpty()) return null

        return deserialize(data, start = 1, end = data.lastIndex - 1)
    }

    private fun deserialize(data: String, start: Int, end: Int): Node? {
        var i = start

        var node: Node? = null
        val children = mutableListOf<Node?>()
        while (i <= end) {
            if (data[i].isDigit()) {
                val digitStart = i
                while (i <= end && data[i].isDigit()) {
                    i++
                }
                val value = data.substring(digitStart, i).toInt()
                node = Node(value)
                continue
            }

            if (data[i] == ' ') {
                i++
                continue
            }

            if (data[i] == '[') {
                val bracketStart = i++
                var brackets = 1

                while (i <= end && brackets != 0) {
                    when (data[i]) {
                        '[' -> brackets++
                        ']' -> brackets--
                    }
                    i++
                }
                children += deserialize(data, start = bracketStart + 1, end = i - 2)
                continue
            }
        }

        node?.children = children.filterNotNull()
        return node
    }
}

fun main() {
    val input = node(1) {
        node(3) {
            node(5)
            node(6)
        }
        node(2)
        node(4)
    }

    val codec = Codec()
    val serialized = codec.serialize(input)
    val deserialized = codec.deserialize(serialized).let(codec::serialize)

    println(serialized)
    require(serialized == "[1 [3 [5] [6]] [2] [4]]")

    println(deserialized)
    require(deserialized == serialized)
}
