package cn.dong.algs4.sort;

import org.jetbrains.annotations.NotNull;

/**
 * @author dong on 2018/08/06.
 */
public class ShellJava {

    public static <T extends Comparable<? super T>> void sortA(@NotNull T[] a) {
        int n = a.length;

        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && (a[j]).compareTo(a[j - h]) < 0; j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static <T extends Comparable<? super T>> void sortB(@NotNull T[] a) {
        int n = a.length;

        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if ((a[j]).compareTo(a[j - h]) < 0) {
                        swap(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h /= 3;
        }
    }

    private static <T> void swap(@NotNull T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
