@file:Suppress("ClassName", "EnumEntryName")

package kotlin

import kotlin.annotation.AnnotationTarget.FILE

@Target(FILE)
annotation class GraphAlgorithm(
    val directed: directed,
    val cyclic: cyclic,
    val weighted: weighted,
)

enum class directed {
    yes, no, both
}

enum class cyclic {
    yes, no, both
}

enum class weighted {
    yes, no, both
}
