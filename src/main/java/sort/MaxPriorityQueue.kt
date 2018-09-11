package sort

/**
 * 最大优先级队列
 *
 * @author dong on 2018/09/03.
 */
interface MaxPriorityQueue<Key : Comparable<Key>> {
    fun insert(key: Key)

    fun max(): Key

    fun deleteMax(): Key

    fun isEmpty(): Boolean

    fun size(): Int

}