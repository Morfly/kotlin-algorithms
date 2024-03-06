@file:Suppress("ClassName", "EnumEntryName")

package kotlin

import kotlin.annotation.AnnotationTarget.FILE

@Target(FILE)
annotation class SortingAlgorithm(
    val stable: stable,
    val inPlace: `in-place`,
    val comparative: comparative,
    val recursive: recursive,
)

enum class stable {
    yes, no
}

enum class `in-place` {
    yes, no
}

enum class comparative {
    yes, no
}

enum class recursive {
    yes, no
}
