import cn.dong.algs4.Queue
import edu.princeton.cs.algs4.StdOut
import org.junit.Test

/**
 * @author dong on 2018/05/06.
 */
class QueueTest {
    private val source = arrayOf("to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is")

    @Test
    fun test() {
        val queue = Queue<String>()
        source.forEach {
            when {
                it != "-" -> queue.enqueue(it)
                !queue.isEmpty() -> StdOut.print(queue.dequeue() + " ")
            }
        }
        StdOut.print("(${queue.size()} left on queue)")

        StdOut.print("\nqueue: ")
        for (s in queue) {
            StdOut.print(s + " ")
        }
    }
}