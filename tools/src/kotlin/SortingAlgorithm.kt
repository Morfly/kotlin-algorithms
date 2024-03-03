package kotlin

import kotlin.annotation.AnnotationTarget.FILE

@Target(FILE)
annotation class SortingAlgorithm(
    val stable: Stable,
    val inPlace: InPlace,
    val comparative: Comparative,
    val recursive: Recursive,
)

/**
 * Equal array elements maintain their original relative order after sorting.
 */
@Target()
annotation class Stable(val value: Boolean)

@Target()
annotation class InPlace(val value: Boolean)

@Target()
annotation class Comparative(val value: Boolean)

@Target()
annotation class Recursive(val value: Boolean)
