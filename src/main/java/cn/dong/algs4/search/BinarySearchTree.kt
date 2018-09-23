package cn.dong.algs4.search

/**
 * @author dong on 2018/09/23.
 */
class BinarySearchTree<K : Comparable<K>, V> : OrderedSymbolTable<K, V> {
    var root: Node<K, V>? = null

    class Node<K, V>(val key: K, var value: V) {
        var left: Node<K, V>? = null
        var right: Node<K, V>? = null
    }

    override val size: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun isEmpty(): Boolean {
        return root == null
    }

    override fun put(key: K, value: V) {
        if (root == null) {
            root = Node(key, value)
            return
        }

        var n = root
        while (n != null) {
            val result = key.compareTo(n.key)
            if (result == 0) {
                n.value = value // hit
                return
            } else if (result < 0) {
                if (n.left != null) {
                    n = n.left
                } else {
                    n.left = Node(key, value)
                }
            } else if (result > 0) {
                if (n.right != null) {
                    n = n.right
                } else {
                    n.right = Node(key, value)
                }
            }
        }
    }

    override fun get(key: K): V? {
        var n = root
        while (n != null) {
            val result = key.compareTo(n.key)
            when {
                result == 0 -> return n.value // hit
                result < 0 -> n = n.left
                result > 0 -> n = n.right
            }
        }
        return null
    }

    override fun keys(): Iterable<K> {
        val list = mutableListOf<Node<K, V>>()
        val iterable = Iterable { KeyIterator(list.iterator()) }
        val n = root
        if (n != null) {
            list.add(n)
            var i = 0
            while (i < list.size) {
                list[i].left?.let { list.add(it) }
                list[i].right?.let { list.add(it) }
                i++
            }
        }
        return iterable
    }

    class KeyIterator<K>(val iterator: Iterator<Node<K, *>>) : Iterator<K> {
        override fun hasNext(): Boolean {
            return iterator.hasNext()
        }

        override fun next(): K {
            return iterator.next().key
        }
    }

    override fun delete(key: K) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun contains(key: K): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun min(): K {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun max(): K {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun floor(): K {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ceiling(): K {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rank(key: K): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun select(rank: Int): K {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteMin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteMax() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun size(low: K, high: K): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun keys(low: K, high: K): Iterable<K> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}