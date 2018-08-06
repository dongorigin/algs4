package benchmark

import edu.princeton.cs.algs4.Stopwatch

/**
 * View Kotlin bytecode and decompile to Java, to investigate the cause of performance differences
 * IntelliJ IDEA: Tools -> Kotlin -> Show Kotlin Bytecode
 *
 * @author dong on 2018/08/06.
 */
fun main(args: Array<String>) {
    val n = 1000000000

    val sw1 = Stopwatch()
    forStandard(n)
    println("for          time: ${sw1.elapsedTime()}")

    val sw2 = Stopwatch()
    forRangesStep(n)
    println("ranges step  time: ${sw2.elapsedTime()}")

    // my test results
    // for          time: 0.003
    // ranges step  time: 0.332
}

/**
 * version A
 * decompile to Java is a for loop
 */
fun forStandard(n: Int) {
    for (i in 0 until n) {
    }
}

/**
 * version B, logically equivalent to A
 * decompile to Java is a mass of code, and the performance is much lower than A
 */
fun forRangesStep(n: Int) {
    for (i in 0 until n step 1) {
    }
}