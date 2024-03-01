package kotlin

annotation class Worst(val value: String)
annotation class Average(val value: String)

annotation class Comment(val value: String)

@Target(AnnotationTarget.FUNCTION)
annotation class TimeComplexity(
    val value: String,
    val comment: Comment = Comment(""),
)

@Target(AnnotationTarget.FUNCTION)
annotation class TimeComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val comment: Comment = Comment(""),
)

@Target(AnnotationTarget.FUNCTION)
annotation class SpaceComplexity(
    val value: String,
    val comment: Comment = Comment(""),
)

@Target(AnnotationTarget.FUNCTION)
annotation class SpaceComplexities(
    val worst: Worst = Worst(""),
    val average: Average = Average(""),
    val comment: Comment = Comment(""),
)
