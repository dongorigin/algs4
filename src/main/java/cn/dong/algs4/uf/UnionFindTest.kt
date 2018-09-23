package cn.dong.algs4.uf

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.Stopwatch

/**
 * @author dong on 2018/08/04.
 */
fun main(args: Array<String>) {
    val input = In("data/largeUF.txt")
    val n = input.readInt()
    val unionFind = WeightedQuickUnion(n)

    val stopwatch = Stopwatch()
    while (!input.isEmpty) {
        val p = input.readInt()
        val q = input.readInt()
        if (!unionFind.connected(p, q)) {
            unionFind.union(p, q)
            println("$p $q")
        }
    }
    println("${unionFind.count()} components")
    println("time ${stopwatch.elapsedTime()}")
}