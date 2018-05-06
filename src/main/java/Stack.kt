/**
 * @author dong on 2018/05/06.
 */
class Stack<Item> : Iterable<Item> {
    private var first: Node<Item>? = null
    private var size = 0

    private class Node<Item>(
            val item: Item,
            var next: Node<Item>? = null
    )

    fun push(item: Item) {
        val oldFirst = first
        first = Node(item, oldFirst)
        size++
    }

    fun pop(): Item {
        first?.let {
            first = it.next
            size--
            return it.item
        } ?: throw NoSuchElementException()
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    fun size(): Int {
        return size
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