package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3, 2, 6};
        SortUnsorted(a, 0, 7);
        System.out.println(Arrays.toString(a));
    }

    public static void SortUnsorted(int[] a, int low, int high) {

        if (high <= low)                    // Делим рекурсивно массив.
            return;
        int mid = low + (high - low) / 2;
        SortUnsorted(a, low, mid);
        SortUnsorted(a, mid + 1, high);

        int[] buffer = Arrays.copyOf(a, a.length); // Добавляем элементы во временный массив.

        for (int k = low; k <= high; k++) // Сравниваем временный массив и оригинальный, а также производим сортировку.
            buffer[k] = a[k];

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {

            if (i > mid) {
                a[k] = buffer[j];
                j++;
            } else if (j > high) {
                a[k] = buffer[i];
                i++;
            } else if (buffer[j] < buffer[i]) {
                a[k] = buffer[j];
                j++;
            } else {
                a[k] = buffer[i];
                i++;
            }
        }
    }
}
