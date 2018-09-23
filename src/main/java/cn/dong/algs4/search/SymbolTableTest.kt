package cn.dong.algs4.search

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdOut

/**
 * @author dong on 2018/09/23.
 */

fun main(args: Array<String>) {
    val input = In("data/tinyST.txt")
    val st = BinarySearchTree<String, Int>()
    var i = 0
    while (!input.isEmpty) {
        val key = input.readString()
        st.put(key, i)
        i++
    }
    for (s in st.keys()) {
        StdOut.println(s + " " + st[s])
    }
}