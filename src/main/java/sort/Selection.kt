package sort

/**
 * 选择剩余元素中最小者，放到剩余序列最前面
 *
 * @author dong on 2018/08/05.
 */
object Selection : Sorter {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 0 until array.size) {
            var minIndex = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }
            array.swap(i, minIndex)
        }
    }
}