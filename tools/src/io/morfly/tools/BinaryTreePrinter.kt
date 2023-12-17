package io.morfly.tools

import kotlin.reflect.KProperty1

fun Any.printBinaryTree() {
    convertToPrintableBinaryTree<Any>().print()
}

fun <T> BinaryTree<T>.print() {
    fun BinaryTree<T>.traverseInorder(builder: StringBuilder, prefix: String, isLeft: Boolean) {
        val pointer = if (isLeft) "└──" else "┌──"

        val rightPadding = if (isLeft && right != null) "$prefix│  " else "$prefix   "
        right?.traverseInorder(builder, prefix = rightPadding, isLeft = false)

        builder.apply {
            append(prefix)
            append(pointer)
            append(value)
            append("\n")
        }

        val leftPadding = if (!isLeft && left != null) "$prefix│  " else "$prefix   "
        left?.traverseInorder(builder, prefix = leftPadding, isLeft = true)
    }

    val builder = StringBuilder()
    traverseInorder(builder, prefix = "", isLeft = true)

    println(builder.toString())
}

fun <T> Any.convertToPrintableBinaryTree(): BinaryTree<T> {
    val valueProperty = getProperty<T>("value") { getProperty("val") }
    val tree = BinaryTree(value = valueProperty.get(this))
    tree.left = getProperty<Any?>("left").get(this)?.convertToPrintableBinaryTree()
    tree.right = getProperty<Any?>("right").get(this)?.convertToPrintableBinaryTree()
    return tree
}

@Suppress("UNCHECKED_CAST")
private fun <T> Any.getProperty(
    name: String,
    fallback: (() -> KProperty1<Any, T>)? = null
): KProperty1<Any, T> {
    val property = this::class.members.firstOrNull { it.name == name } as? KProperty1<Any, T>
    return property ?: fallback?.invoke() ?: error("Binary tree node must have a '$name' property.")
}
