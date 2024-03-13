# Kotlin Algorithms and Data Structures

## Project structure

### Foundation

- [Binary search tree](src/foundation/binary-search-tree)
- [Binary tree](src/foundation/binary-tree)
    - [Breadth-first search](src/foundation/binary-tree/breadth-first-search)
    - [Depth-first search](src/foundation/binary-tree/depth-first-search)
    - [Morris traversal](src/foundation/binary-tree/morris-traversal)
- [Disjoint set union](src/foundation/disjoint-set-union)
- [Graph](src/foundation/graph)
    - [Breadth-first search](src/foundation/graph/breadth-first-search)
    - [Depth-first search](src/foundation/graph/depth-first-search)
    - [Dijkstra's algorithm](src/foundation/graph/dijkstra)
    - [Topological sort](src/foundation/graph/topological-sort)
        - [Depth-first search](src/foundation/graph/topological-sort/dfs-topological-sort.kt)
        - [Kahn's algorithm](src/foundation/graph/topological-sort/kahn-topological-sort.kt)
- [Heap](src/foundation/heap/min-heap.kt)
- [Minimum spanning tree](src/foundation/minimum-spanning-tree)
    - [Kruskal's algorithm](src/foundation/minimum-spanning-tree/kruskal/kruskal-mst.kt)
- [Parallel sorting](src/foundation/parallel-sorting)
    - [Merge sort](src/foundation/parallel-sorting/parallel-merge-sort)
    - [Quick sort](src/foundation/parallel-sorting/parallel-quick-sort)
- [Search](src/foundation/search)
    - [Linear search](src/foundation/search/linear)
    - [Binary search](src/foundation/search/binary)
- [Sorting](src/foundation/sorting)
    - [Bubble sort](src/foundation/sorting/bubble-sort/bubble-sort.kt)
    - [Selection sort](src/foundation/sorting/selection-sort/selection-sort.kt)
    - [Insertion sort](src/foundation/sorting/insertion-sort/insertion-sort.kt)
    - [Shell sort](src/foundation/sorting/shell-sort/shell-sort.kt)
    - [Heap sort](src/foundation/sorting/heap-sort/heap-sort.kt)
    - [Merge sort](src/foundation/sorting/merge-sort/merge-sort.kt)
    - [Quick sort](src/foundation/sorting/quick-sort/quick-sort.kt)
    - [Bucket sort](src/foundation/sorting/bucket-sort/bucket-sort.kt)
    - [Counting sort](src/foundation/sorting/counting-sort/counting-sort.kt)
    - [Radix sort](src/foundation/sorting/radix-sort/radix-sort.kt)

### Exercises

- [Dynamic programming](src/exercises/dynamic-programming)
    - [Fibonacci sequence](src/exercises/dynamic-programming/fibonacci/fibonacci.kt)
    - [Count paths](src/exercises/dynamic-programming/count-the-paths/recursive-solution.kt)

### LeetCode

- [1. Two Sum](src/leetcode/1-two-sum/solution.kt)
- [20. Valid Parentheses](src/leetcode/20-valid-parentheses/solution.kt)
- [21. Merge Two Sorted Lists](src/leetcode/21-merge-two-sorted-lists/solution.kt)
- [23. Merge k Sorted Lists](src/leetcode/23-merge-k-sorted-lists/solution-3.kt)
- [34. Find First and Last Position of Element in Sorted Array](src/leetcode/34-find-first-and-last-position-of-element-in-sorted-array/solution.kt)
- [39. Combination Sum](src/leetcode/39-combination-sum/solution.kt)
- [40. Combination Sum II](src/leetcode/40-combination-sum-II/solution.kt)
- [46. Permutations](src/leetcode/46-permutations/solution.kt)
- [47. Permutations II](src/leetcode/47-permutations-II/solution.kt)
- [48. Rotate Image](src/leetcode/48-rotate-image/solution.kt)
- [49. Group Anagrams](src/leetcode/49-group-anagrams/solution.kt)
- [50. Pow(x, n)](src/leetcode/50-pow-x-n/solution.kt)
- [53. Maximum Subarray](src/leetcode/53-maximum-subarray/solution.kt)
- [54. Spiral Matrix](src/leetcode/54-spiral-matrix/solution.kt)
- [56. Merge Intervals](src/leetcode/56-merge-intervals/solution.kt)
- [62. Unique Paths](src/leetcode/62-unique-paths/solution.kt)
- [70. Climbing Stairs](src/leetcode/70-climbing-stairs/solution.kt)
- [71. Simplify Path](src/leetcode/71-simplify-path/solution.kt)
- [78. Subsets](src/leetcode/78-subsets/solution.kt)
- [79. Word Search](src/leetcode/79-word-search/solution.kt)
- [88. Merge Sorted Array](src/leetcode/88-merge-sorted-array/solution.kt)
- [90. Subsets II](src/leetcode/90-subsets-II/solution.kt)
- [94. Binary Tree Inorder Traversal](src/leetcode/94-binary-tree-inorder-traversal/solution-1.kt)
- [112. Path Sum](src/leetcode/112-path-sum/solution.kt)
- [121. Best Time to Buy and Sell Stock](src/leetcode/121-best-time-to-buy-and-sell-stock/solution.kt)
- [125. Valid Palindrome](src/leetcode/125-valid-palindrome/solution.kt)
- [129. Sum Root to Leaf Numbers](src/leetcode/129-sum-root-to-leaf-numbers/solution.kt)
- [131. Palindrome Partitioning](src/leetcode/131-palindrome-partitioning/solution.kt)
- [136. Single Number](src/leetcode/136-single-number/solution.kt)
- [152. Maximum Product Subarray](src/leetcode/152-maximum-product-subarray/solution.kt)
- [153. Find Minimum in Rotated Sorted Array](src/leetcode/153-find-minimum-in-rotated-sorted-array/solution.kt)
- [160. Intersection of Two Linked Lists](src/leetcode/160-intersection-of-two-linked-lists/solution.kt)
- [162. Find Peak Element](src/leetcode/162-find-peak-element/solution.kt)
- [191. Number of 1 Bits](src/leetcode/191-number-of-1-bits/solution.kt)
- [199. Binary Tree Right Side View](src/leetcode/199-binary-tree-right-side-view/solution.kt)
- [200. Number of Islands](src/leetcode/200-number-of-islands/solution.kt)
- [207. Course Schedule](src/leetcode/207-course-schedule/solution.kt)
- [215. Kth Largest Element in an Array](src/leetcode/215-kth-largest-element-in-an-array/solution-2.kt)
- [226. Invert Binary Tree](src/leetcode/226-invert-binary-tree/solution.kt)
- [227. Basic Calculator II](src/leetcode/227-basic-calculator-II/solution.kt)
- [252. Meeting Rooms](src/leetcode/252-meeting-rooms/solution.kt)
- [253. Meeting Rooms II](src/leetcode/253-meeting-rooms-II/solution.kt)
- [269. Alien Dictionary](src/leetcode/269-alien-dictionary/solution.kt)
- [270. Closest Binary Search Tree Value](src/leetcode/270-closest-binary-search-tree-value/solution.kt)
- [277. Find the Celebrity](src/leetcode/277-find-the-celebrity/solution.kt)
- [283. Move Zeros](src/leetcode/283-move-zeros/solution.kt)
- [314. Binary Tree Vertical Order Traversal](src/leetcode/314-binary-tree-vertical-order-traversal/solution.kt)
- [320. Coin Change](src/leetcode/320-coin-change/solution.kt)
- [332. Reconstruct Itinerary](src/leetcode/332-reconstruct-itinerary/solution.kt)
- [339. Nested List Weight Sum](src/leetcode/339-nested-list-weight-sum/solution.kt)
- [346. Moving Average from Data Stream](src/leetcode/346-moving-average-from-data-stream/solution.kt)
- [347. Top K Frequent Elements](src/leetcode/347-top-k-frequent-elements/solution-2.kt)
- [350. Intersection of Two Arrays II](src/leetcode/350-intercection-of-two-arrays-II/solution.kt)
- [383. Ransom Note](src/leetcode/383-ransom-note/solution-2.kt)
- [408. Valid Word Abbreviation](src/leetcode/408-valid-word-abbreviation/solution.kt)
- [426. Convert Binary Search Tree to Sorted Doubly Linked List](src/leetcode/426-convert-binary-search-tree-to-sorted-doubly-linked-list/solution.kt)
- [428. Serialize and Deserialize N-ary Tree](src/leetcode/428-serialize-and-deserialize-n-ary-tree/solution.kt)
- [450. Delete Node in a BST](src/leetcode/450-delete-node-in-a-bst/solution.kt)
- [523. Continuous Subarray Sum](src/leetcode/523-continuous-subarray-sum/solution.kt)
- [528. Random Pick with Weight](src/leetcode/528-random-pick-with-weight/solution.kt)
- [543. Diameter of Binary Tree](src/leetcode/543-diameter-of-binary-tree/solution.kt)
- [560. Subarray Sum Equals K](src/leetcode/560-subarray-sum-equals-k/solution.kt)
- [658. Find K Closest Elements](src/leetcode/658-find-k-closest-elements/solution-1.kt)
- [695. Max Area of Island](src/leetcode/695-max-area-of-islands/solution.kt)
- [708. Insert into a Sorted Circular Linked List](src/leetcode/708-insert-into-a-sorted-circular-linked-list/solution.kt)
- [791. Custom Sort String](src/leetcode/791-custom-sort-string/solution-2.kt)
- [827. Making A Large Island](src/leetcode/827-making-a-large-island/solution.kt)
- [919. Meeting Rooms II](src/leetcode/919-meeting-rooms-II/solution.kt)
- [921. Minimum Add to Make Parentheses Valid](src/leetcode/921-minimum-add-to-make-parentheses-valid/solution.kt)
- [938. Range Sum of BST](src/leetcode/938-range-sum-of-bst/solution.kt)
- [986. Interval List Intersections](src/leetcode/986-interval-list-intersections/solution.kt)
- [1091. Shortest Path in Binary Matrix](src/leetcode/1091-shortest-path-in-binary-matrix/solution.kt)
- [1249. Minimum Remove to Make Valid Parentheses](src/leetcode/1249-minimum-remove-to-make-valid-parentheses/solution.kt)
- [1522. Diameter of N-Ary Tree](src/leetcode/1522-diameter-of-n-ary-tree/solution.kt)
- [1570. Dot Product of Two Sparse Vectors](src/leetcode/1570-dot-product-of-two-sparce-arrays/solution.kt)
- [1650. Lowest Common Ancestor of a Binary Tree III](src/leetcode/1650-lowest-common-ancestor-of-a-binary-tree-III/solution-2.kt)
- [1762. Buildings With an Ocean View](src/leetcode/1762-buildings-with-an-ocean-view/solution.kt)
- [1861. Rotating the Box](src/leetcode/1861-rotating-the-box/solution.kt)
- [2401. Meeting Rooms III](src/leetcode/2402-meeting-rooms-III/solution.kt)
