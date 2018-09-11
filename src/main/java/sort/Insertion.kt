package sort

/**
 * 将每一个元素放到已排序序列中的适当位置。就像人们整理纸牌的方式
 *
 * @author dong on 2018/08/05.
 */
object Insertion : Sorter {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 1 until array.size) {
            for (j in i downTo 1) {
                if (array[j] < array[j - 1]) {
                    array.swap(j, j - 1)
                } else {
                    break
                }
            }
        }
    }
}