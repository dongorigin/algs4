import cn.dong.algs4.Bag
import edu.princeton.cs.algs4.StdOut
import org.junit.Test

/**
 * @author dong on 2018/05/06.
 */
class BagTest {
    private val source = arrayOf("to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is")

    @Test
    fun test() {
        val bag = Bag<String>()
        source.forEach {
            bag.add(it)
        }

        StdOut.print("bag: ")
        bag.forEach { StdOut.print(it + " ") }
    }
}