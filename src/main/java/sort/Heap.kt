package sort

/**
 * heapsort
 *
 * @author dong on 2018/09/22.
 */
object Heap : Sorter {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        var n = array.size

        // heap construction
        for (k in (n / 2) downTo 1) {
            sink(array, k, n)
        }

        // sortdown
        while (n > 1) {
            swap(array, 1, n)
            n--
            sink(array, 1, n)
        }
    }

    private fun <T : Comparable<T>> sink(a: Array<T>, k: Int, n: Int) {
        var i = k
        while (i * 2 <= n) { // left child exist
            var target = i * 2
            if (target + 1 <= n && less(a, target, target + 1)) { // left child < right child
                target = target + 1
            }
            if (!less(a, i, target)) { // i >= target
                break
            }
            swap(a, i, target)
            i = target
        }
    }

    /**
     * @return true a[i] < a[j], false a[i] >= a[j]
     */
    private fun <T : Comparable<T>> less(a: Array<T>, i: Int, j: Int): Boolean {
        return a[i - 1] < a[j - 1]
    }

    private fun <T> swap(array: Array<T>, i: Int, j: Int) {
        array.swap(i - 1, j - 1)
    }
}
