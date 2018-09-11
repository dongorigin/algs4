package sort

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdOut

/**
 * 基于二叉堆的优先级队列
 *
 * @author dong on 2018/09/11.
 */
class HeapMaxPriorityQueue<Key : Comparable<Key>>(size: Int) : MaxPriorityQueue<Key> {
    private val heap = ArrayList<Key>(size)
    private var n = 0 // number of items on queue

    override fun isEmpty(): Boolean {
        return n == 0
    }

    override fun size(): Int {
        return n
    }

    override fun insert(key: Key) {
        if (n == 0) {
            heap.add(key) // fill heap[0]
        }
        heap.add(key)
        n++
        swim(n)
    }

    override fun deleteMax(): Key {
        if (isEmpty()) {
            throw IllegalStateException("queue is empty")
        }
        val max = heap[1]
        heap[1] = heap[n]
        heap.removeAt(n--)
        if (n == 0) heap.clear() // remove heap[0]
        sink(1)
        return max
    }

    override fun max(): Key {
        if (isEmpty()) {
            throw IllegalStateException("queue is empty")
        }
        return heap[1]
    }

    // heap[k/2] is the parent of heap[k]
    private fun swim(k: Int) {
        var i = k
        while (i > 1 && heap[i] > heap[i / 2]) {
            heap.swap(i, i / 2)
            i /= 2
        }
    }

    // heap[2k] and heap[2k+1] is the child of heap[k]
    private fun sink(k: Int) {
        var i = k
        while (i * 2 <= n) { // left child exist
            val left = i * 2 // left child
            val right = i * 2 + 1 // right child
            if (right <= n && heap[right] > heap[left] && heap[i] < heap[right]) {
                heap.swap(i, right)
                i = right
            } else if (heap[i] < heap[left]) {
                heap.swap(i, left)
                i = left
            } else {
                break
            }
        }
    }
}

fun main(args: Array<String>) {
    val input = In("data/8ints.txt")
    val ints = input.readAllInts().toTypedArray()

    val pq = HeapMaxPriorityQueue<Int>(10)
    ints.forEach {
        pq.insert(it)
    }
    while (!pq.isEmpty()) {
        StdOut.print("${pq.deleteMax()} ")
    }
}
