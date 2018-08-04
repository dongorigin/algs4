package uf

/**
 * @author dong on 2018/08/04.
 */
interface UnionFind {
    fun count(): Int
    fun find(p: Int): Int
    fun connected(p: Int, q: Int): Boolean
    fun union(p: Int, q: Int)
}