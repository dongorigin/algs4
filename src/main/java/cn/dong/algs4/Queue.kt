package cn.dong.algs4

/**
 * @author dong on 2018/05/06.
 */
class Queue<Item> : Iterable<Item> {
    private var first: Node<Item>? = null
    private var last: Node<Item>? = null
    private var size = 0

    fun enqueue(item: Item) {
        val new = Node(item)
        if (last == null) {
            first = new
            last = new
        } else {
            last?.next = new
            last = new
        }
        size++
    }

    fun dequeue(): Item {
        first?.let {
            first = it.next
            if (first == null) {
                last = null
            }
            size--
            return it.item
        } ?: throw NoSuchElementException()
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    fun size() = size

    override fun iterator(): Iterator<Item> {
        return NodeIterator(first)
    }
}