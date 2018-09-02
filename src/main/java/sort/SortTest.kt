package sort

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdOut

/**
 * @author dong on 2018/08/05.
 */
fun main(args: Array<String>) {
    val input = In("data/8ints.txt")
    val ints = input.readAllInts().toTypedArray()
    Quick.sort(ints)
    assert(isSorted(ints))
    show(ints)
}

fun <T : Comparable<T>> isSorted(array: Array<T>): Boolean {
    for (i in 1 until array.size) {
        if (array[i] < array[i - 1]) {
            return false
        }
    }
    return true
}

fun <T : Comparable<T>> isSorted(array: Array<T>, low: Int, high: Int): Boolean {
    for (i in low + 1..high) {
        if (array[i] < array[i - 1]) {
            return false
        }
    }
    return true
}

fun show(array: Array<*>) {
    array.forEach { StdOut.print("$it ") }
    StdOut.println()
}