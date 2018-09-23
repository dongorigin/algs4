package cn.dong.algs4.sort

import edu.princeton.cs.algs4.StdRandom

/**
 * quicksort (sometimes called partition-exchange sort)
 *
 * @author dong on 2018/09/02.
 */
object Quick : Sorter {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        StdRandom.shuffle(array)
        sort(array, 0, array.size - 1)
    }

    private fun <T : Comparable<T>> sort(array: Array<T>, low: Int, high: Int) {
        if (low >= high) return // recursion exit

        val partition = partition(array, low, high)
        sort(array, low, partition - 1)
        sort(array, partition + 1, high)

        assert(isSorted(array, low, high))
    }

    private fun <T : Comparable<T>> partition(array: Array<T>, low: Int, high: Int): Int {
        require(low < high) { "low[$low] >= high[$high]" }

        val partition = array[low]
        var left = low + 1
        var right = high
        while (true) {
            // left
            while (array[left] < partition && left < right) {
                left++
            }

            // right
            while (array[right] > partition && right > left) {
                right--
            }

            if (left >= right) {
                break
            }

            array.swap(left, right)

            if (left == right - 1) {
                break
            } else {
                left++
                right--
            }
        }

        if (array[left] > partition) {
            left--
        }

        // a[low] a[low+1..left] a[right..hi]
        array.swap(low, left)

        // a[low..left-1] <= a[left] <= a[right..hi]
        return left
    }
}