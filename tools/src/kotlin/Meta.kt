package kotlin

@Target(AnnotationTarget.FILE)
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
    Heap,
    BreadthFirstSearch,
    DepthFirstSearch,
    Stack,
    LinkedList,
    QuickSelect,
    Sorting,
}