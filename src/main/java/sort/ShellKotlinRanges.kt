package sort

/**
 * @author dong on 2018/08/06.
 */
object ShellKotlinRanges : Sorter {

    override fun <T : Comparable<T>> sort(array: Array<T>) {
        var h = 1
        while (h < array.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            // h-sort the array
            for (i in h until array.size) {
                for (j in i downTo h step h) {
                    if (array[j] < array[j - h]) {
                        array.swap(j, j - h)
                    } else {
                        break
                    }
                }
            }
            h /= 3
        }
    }
}
