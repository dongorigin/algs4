package sort

/**
 * @author dong on 2018/08/26.
 */
object Merge : Sorter {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        val aux = array.copyOf() // kotlin null check
        sort(array, aux, 0, array.size - 1)
    }

    // sort a[lo..hi]
    private fun <T : Comparable<T>> sort(array: Array<T>, aux: Array<T>, lo: Int, hi: Int) {
        if (lo >= hi) {
            return
        }

        val mid = (lo + hi) / 2
        sort(array, aux, lo, mid)
        sort(array, aux, mid + 1, hi)
        merge(array, aux, lo, mid, hi)
    }

    // merge a[lo..mid] and a[mid+1..hi]
    private fun <T : Comparable<T>> merge(a: Array<T>, aux: Array<T>, lo: Int, mid: Int, hi: Int) {
        // a[lo..hi] copy to aux[lo..hi]
        for (index in lo..hi) {
            aux[index] = a[index]
        }

        // merge aux[lo..mid] and aux[mid+1..hi] to a[lo..hi]
        var left = lo
        var right = mid + 1
        for (index in lo..hi) {
            when {
                left > mid -> a[index] = aux[right++]
                right > hi -> a[index] = aux[left++]
                aux[left] < aux[right] -> a[index] = aux[left++]
                else -> a[index] = aux[right++]
            }
        }
    }
}