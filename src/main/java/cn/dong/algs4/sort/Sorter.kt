package cn.dong.algs4.sort

/**
 * @author dong on 2018/08/05.
 */
interface Sorter {

    fun <T : Comparable<T>> sort(array: Array<T>)

}