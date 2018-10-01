package cn.dong.algs4.search

/**
 * Hash table with separate chaining
 *
 * @author dong on 2018/10/01.
 */
class HashST<K : Any, V> : SymbolTable<K, V> {
    private var n: Int = 0 // number of key-value pairs
    private var m: Int // hash table size
    private val st: Array<SequentialSearchST<K, V>>

    constructor(m: Int) {
        this.m = m
        st = Array(m) { SequentialSearchST<K, V>() }
    }

    override val size: Int
        get() = n

    override fun isEmpty(): Boolean {
        return size == 0
    }

    private fun hash(key: K): Int {
        checkNotNull(key)
        return key.hashCode().and(0x7fffffff) % m
    }

    override fun put(key: K, value: V) {
        st[hash(key)].put(key, value)
    }

    override fun get(key: K): V? {
        return st[hash(key)][key]
    }

    override fun delete(key: K) {
        st[hash(key)].delete(key)
    }

    override fun contains(key: K): Boolean {
        return st[hash(key)].contains(key)
    }

    override fun keys(): Iterable<K> {
        return st.flatMap { it.keys() }
    }
}
