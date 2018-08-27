package sort

import kotlin.math.min

/**
 * bottom-up merge sort
 *
 * @author dong on 2018/08/27.
 */
object MergeBU : Sorter {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        val aux = array.copyOf() // kotlin null check

        var length = 1
        while (length < array.size) {
            var low = 0
            while (low < array.size - length) {
                val mid = low + length - 1
                val high = min(mid + length, array.size - 1)
                merge(array, aux, low, mid, high)

                low = high + 1
            }

            length *= 2
        }
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