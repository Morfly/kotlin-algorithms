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
    String,
    Array,
    Matrix,
    HashTable,
    Backtracking,
    SlidingWindow,
    DynamicProgramming,
    Recursion,
    BinarySearch,
    BinaryTree,
    BinarySearchTree,
    Tree,
    Heap,
    Graph,
    Queue,
    Stack,
    BreadthFirstSearch,
    DepthFirstSearch,
    TopologicalSort,
    LinkedList,
    QuickSelect,
    Sorting,
    MergeSort,
    BucketSort,
    TwoPointers,
    Intervals,
    BitManipulation,
    PrefixSum,
    Math,
}