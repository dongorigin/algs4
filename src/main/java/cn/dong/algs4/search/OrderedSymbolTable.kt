package cn.dong.algs4.search

/**
 * @author dong on 2018/09/22.
 */
interface OrderedSymbolTable<Key : Comparable<Key>, Value> : SymbolTable<Key, Value> {
    fun min(): Key
    fun max(): Key
    fun floor(): Key
    fun ceiling(): Key
    fun rank(key: Key): Int
    fun select(rank: Int): Key
    fun deleteMin()
    fun deleteMax()
    fun size(low: Key, high: Key): Int
    fun keys(low: Key, high: Key): Iterable<Key>
}
