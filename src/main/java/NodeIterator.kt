/**
 * @author dong on 2018/05/06.
 */
class NodeIterator<Item>(var current: Node<Item>?) : Iterator<Item> {
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