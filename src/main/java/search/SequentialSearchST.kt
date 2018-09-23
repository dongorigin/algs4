package search

/**
 * based linked list
 *
 * @author dong on 2018/09/22.
 */
class SequentialSearchST<K, V> : SymbolTable<K, V> {

    private var first: Node<K, V>? = null

    override var size: Int = 0
        private set

    override fun isEmpty(): Boolean {
        return first == null
    }

    override fun put(key: K, value: V) {
        var node = first
        while (node != null) {
            if (node.key == key) { // hit
                node.value = value
                return
            } else {
                node = node.next
            }
        }

        // key not exist, add to the first
        first = Node(key, value, first)
        size++
    }

    override fun get(key: K): V? {
        var node = first
        while (node != null) {
            if (node.key == key) { // hit
                return node.value
            } else {
                node = node.next
            }
        }
        return null
    }

    override fun delete(key: K) {
        var previous: Node<K, V>? = null
        var current = first
        while (current != null) {
            if (current.key == key) { // hit
                if (previous != null) {
                    previous.next = current.next
                } else {
                    first = null
                }
                size--
                return
            } else {
                previous = current
                current = current.next
            }
        }
    }

    override fun contains(key: K): Boolean {
        return get(key) != null
    }

    override fun keys(): Iterable<K> {
        return Iterable { KeyIterator(first) }
    }

    class Node<K, V>(
            val key: K,
            var value: V,
            var next: Node<K, V>?)

    class KeyIterator<K>(var current: Node<K, *>?) : Iterator<K> {
        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): K {
            val node = current
            if (node != null) {
                current = node.next
                return node.key
            } else {
                throw NoSuchElementException()
            }
        }
    }
}
