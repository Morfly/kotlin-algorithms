package kotlin

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION

@Target(FUNCTION, CLASS)
annotation class TimeComplexity(
    val value: String,
    val comment: Comment = Comment()
)

@Target(FUNCTION, CLASS)
annotation class TimeComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val comment: Comment = Comment(),
    val best: Best = Best(""),
)

@Target(FUNCTION, CLASS)
annotation class SpaceComplexity(val value: String, val comment: Comment = Comment(""))

@Target(FUNCTION, CLASS)
annotation class SpaceComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val comment: Comment = Comment(),
    val best: Best = Best(""),
)

@Target()
annotation class Worst(
    val value: String,
    val comment: Comment = Comment()
)

@Target()
annotation class Average(
    val value: String,
    val comment: Comment = Comment()
)

@Target()
annotation class Best(val value: String, val comment: Comment = Comment())
