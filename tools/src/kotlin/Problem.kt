package kotlin

import kotlin.annotation.AnnotationTarget.FILE

@Target(FILE)
annotation class Problem(
    val companies: Array<Company> = [],
    val topics: Array<Topic> = []
)

enum class Company {
    Meta,
    Google,
    Netflix,
}

enum class Topic {
    Array,
    HashMap,
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
    BitManipulation,
}