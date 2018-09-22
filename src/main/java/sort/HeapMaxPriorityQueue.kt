package sort

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdOut

/**
 * 基于二叉堆的优先级队列
 *
 * @author dong on 2018/09/11.
 */
class HeapMaxPriorityQueue<Key : Comparable<Key>>(size: Int) : MaxPriorityQueue<Key> {
    private val heap = MaxHeap<Key>(size)

    override fun size(): Int {
        return heap.size
    }

    override fun isEmpty(): Boolean {
        return size() == 0
    }

    override fun insert(key: Key) {
        heap.insert(key)
    }

    override fun deleteMax(): Key {
        if (isEmpty()) {
            throw IllegalStateException("queue is empty")
        }
        return heap.deleteMax()
    }

    override fun max(): Key {
        if (isEmpty()) {
            throw IllegalStateException("queue is empty")
        }
        return heap.max()
    }

    class MaxHeap<Key : Comparable<Key>>(size: Int) {
        private val list = ArrayList<Key>(size)
        val size: Int
            get() = list.size

        fun insert(key: Key) {
            list.add(key)
            swim(size)
        }

        fun deleteMax(): Key {
            val max = this[1]
            this[1] = this[size]
            removeAt(size)
            sink(1)
            return max
        }

        fun max(): Key {
            return get(1)
        }

        private operator fun get(index: Int): Key {
            require(index >= 1)
            return list.get(index - 1)
        }

        private operator fun set(index: Int, element: Key): Key {
            require(index >= 1)
            return list.set(index - 1, element)
        }

        private fun removeAt(index: Int): Key {
            require(index >= 1)
            return list.removeAt(index - 1)
        }

        private fun swap(i: Int, j: Int) {
            list.swap(i - 1, j - 1)
        }

        // heap[k/2] is the parent of heap[k]
        private fun swim(k: Int) {
            var i = k
            while (i > 1 && this[i] > this[i / 2]) {
                swap(i, i / 2)
                i /= 2
            }
        }

        // heap[2k] and heap[2k+1] is the child of heap[k]
        private fun sink(k: Int) {
            var i = k
            while (i * 2 <= size) { // left child exist
                val left = i * 2 // left child
                val right = i * 2 + 1 // right child
                if (right <= size && this[right] > this[left] && this[i] < this[right]) {
                    swap(i, right)
                    i = right
                } else if (this[i] < this[left]) {
                    swap(i, left)
                    i = left
                } else {
                    break
                }
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
