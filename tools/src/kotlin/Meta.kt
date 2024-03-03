package kotlin

import kotlin.annotation.AnnotationTarget.FILE

// TODO rename to Problem
@Target(FILE)
annotation class Meta(
    val companies: Array<Company> = [],
    val topics: Array<Topic> = []
)

enum class Company {
    Meta,
    Google,
    Netflix,
}

enum class Topic {
    BinarySearch,
    BinaryTree,
    BinarySearchTree,
    Heap,
    Queue,
    Stack,
    BreadthFirstSearch,
    DepthFirstSearch,
    LinkedList,
    QuickSelect,
    Sorting,
    MergeSort,
    BucketSort,
    TwoPointers,
    Intervals,
}