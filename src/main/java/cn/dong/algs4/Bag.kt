package cn.dong.algs4

/**
 * @author dong on 2018/05/06.
 */
class Bag<Item> : Iterable<Item> {
    private var first: Node<Item>? = null
    private var size = 0

    fun add(item: Item) {
        val oldFirst = first
        first = Node(item, oldFirst)
        size++
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

}