package kotlin

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION

annotation class Worst(val value: String)
annotation class Average(val value: String)

annotation class Comment(val value: String)

@Target(FUNCTION, CLASS)
annotation class TimeComplexity(
    val value: String,
    val comment: Comment = Comment(""),
)

@Target(FUNCTION, CLASS)
annotation class TimeComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val comment: Comment = Comment(""),
)

@Target(FUNCTION, CLASS)
annotation class SpaceComplexity(
    val value: String,
    val comment: Comment = Comment(""),
)

@Target(FUNCTION, CLASS)
annotation class SpaceComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val comment: Comment = Comment(""),
)
