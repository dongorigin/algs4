import cn.dong.algs4.Stack
import edu.princeton.cs.algs4.StdOut
import org.junit.Test

/**
 * @author dong on 2018/05/06.
 */
class StackTest {
    private val source = arrayOf("to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is")

    @Test
    fun test() {
        val stack = Stack<String>()
        source.forEach {
            when {
                it != "-" -> stack.push(it)
                !stack.isEmpty() -> StdOut.print(stack.pop() + " ")
            }
        }
        StdOut.print("(${stack.size()} left on stack)")

        StdOut.print("\nstack: ")
        for (s in stack) {
            StdOut.print(s + " ")
        }
    }
}