package controllers;

import java.util.Arrays;

public class SortMethods {

    public int[] sortBubble(int[] numeros) {
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        for (int i = 0; i < cp.length; i++) {
            for (int j = 0; j < cp.length - 1; j++) {
                if (cp[j] > cp[j + 1]) {
                    int temp = cp[j];
                    cp[j] = cp[j + 1];
                    cp[j + 1] = temp;
                }
            }
        }
        return cp;
    }

    public int[] sortBubbleOptimized(int[] numeros) {
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        boolean swapped;
        for (int i = 0; i < cp.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < cp.length - i - 1; j++) {
                if (cp[j] > cp[j + 1]) {
                    int temp = cp[j];
                    cp[j] = cp[j + 1];
                    cp[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return cp;
    }

    public int[] sortShell(int[] numeros) {
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        int n = cp.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = cp[i];
                int j;
                for (j = i; j >= gap && cp[j - gap] > temp; j -= gap) {
                    cp[j] = cp[j - gap];
                }
                cp[j] = temp;
            }
        }
        return cp;
    }

    public int[] sortMerge(int[] numeros) {
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        mergeSort(cp, 0, cp.length - 1);
        return cp;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
