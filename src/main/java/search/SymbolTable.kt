package search

/**
 * @author dong on 2018/09/22.
 */
interface SymbolTable<Key, Value> {
    val size: Int
    fun isEmpty(): Boolean
    fun put(key: Key, value: Value)
    operator fun get(key: Key): Value? // return null if key not exist
    fun delete(key: Key)
    fun contains(key: Key): Boolean
    fun keys(): Iterable<Key>
}
