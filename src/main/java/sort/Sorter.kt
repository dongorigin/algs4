package sort

/**
 * @author dong on 2018/08/05.
 */
interface Sorter {

    fun <T : Comparable<T>> sort(array: Array<T>)

    fun <T> swap(array: Array<T>, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

}