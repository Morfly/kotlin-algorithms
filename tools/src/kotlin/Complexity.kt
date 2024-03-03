package kotlin

import kotlin.annotation.AnnotationTarget.*

@Target(FUNCTION, CLASS, FILE)
annotation class TimeComplexity(val value: String)

@Target(FUNCTION, CLASS, FILE)
annotation class TimeComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val best: Best = Best(""),
)

@Target(FUNCTION, CLASS, FILE)
annotation class SpaceComplexity(val value: String)

@Target(FUNCTION, CLASS, FILE)
annotation class SpaceComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val best: Best = Best(""),
)

@Target()
annotation class Worst(val value: String)

@Target()
annotation class Average(val value: String)

@Target()
annotation class Best(val value: String)
