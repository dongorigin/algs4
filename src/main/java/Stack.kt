/**
 * @author dong on 2018/05/06.
 */
class Stack<Item> : Iterable<Item> {
    private var first: Node<Item>? = null
    private var n = 0

    private class Node<Item>(
            val item: Item,
            var next: Node<Item>? = null
    )

    fun push(item: Item) {
        val oldFirst = first
        first = Node(item, oldFirst)
        n++
    }

    fun pop(): Item {
        first?.let {
            val item = it.item
            first = it.next
            n--
            return item
        } ?: throw NoSuchElementException()
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    fun size(): Int {
        return n
    }

    override fun iterator(): Iterator<Item> {
        return NodeIterator(first)
    }

    private class NodeIterator<Item>(var current: Node<Item>?) : Iterator<Item> {
        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): Item {
            current?.let {
                current = it.next
                return it.item
            } ?: throw NoSuchElementException()
        }
    }
}