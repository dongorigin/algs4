package sort

/**
 * @author dong on 2018/08/05.
 */
object Shell : Sorter {

    override fun <T : Comparable<T>> sort(array: Array<T>) {
        var h = 1
        while (h < array.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            // h-sort the array
            for (i in h until array.size) {
                var j = i
                while (j >= h && array[j] < array[j - h]) {
                    array.swap(j, j - h)
                    j -= h
                }
            }
            h /= 3
        }
    }
}
