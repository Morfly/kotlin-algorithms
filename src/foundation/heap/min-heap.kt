package foundation.heap

class MinHeap(val size: Int) {
    private val heap = IntArray(size)
    private var currentSize = 0

    private fun parent(i: Int): Int = (i - 1) / 2
    private fun leftChild(i: Int): Int = 2 * i + 1
    private fun rightChild(i: Int): Int = 2 * i + 2

    fun insert(element: Int) {
        if (currentSize == size) return

        heap[currentSize] = element
        var i = currentSize
        currentSize++

        while (i != 0 && heap[parent(i)] > heap[i]) {
            heap[i] = heap[parent(i)].also { heap[parent(i)] = heap[i] }
            i = parent(i)
        }
    }

    fun removeMin(): Int {
        val root = heap[0]
        heap[0] = heap[currentSize - 1]
        currentSize--
        heapify(0)

        return root
    }

    private fun heapify(i: Int) {
        val left = leftChild(i)
        val right = rightChild(i)
        var smallest = i

        if (left < currentSize && heap[left] < heap[smallest])
            smallest = left
        if (right < currentSize && heap[right] < heap[smallest])
            smallest = right

        if (smallest != i) {
            heap[i] = heap[smallest].also { heap[smallest] = heap[i] }
            heapify(smallest)
        }
    }
}

fun main() {
    val minHeap = MinHeap(10)
    minHeap.insert(3)
    minHeap.insert(2)
    minHeap.insert(15)
    minHeap.insert(5)
    minHeap.insert(4)
    minHeap.insert(45)

    val first = minHeap.removeMin()
    println(first)
    require(first == 2)

    val second = minHeap.removeMin()
    println(second)
    require(second == 3)
}