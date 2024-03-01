package utilities;

/**
 * Created on Mar 01, 2024
 *
 * @author Team-Purah
 * @version 1.0
 */

import java.util.Arrays;
import java.util.Comparator;

public class SortAlgorithm
{
	// Helper method to swap elements
	private static <T> void swap(T[] arr, int i, int j) 
	{
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Bubble Sort
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j].compareTo(arr[j + 1]) > 0) 
                {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) 
                {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Insertion Sort
    public static <T extends Comparable<T>> void insertionSort(T[] arr) 
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) 
        {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) 
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) 
        {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(arr[j], key) > 0) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort
    public static <T extends Comparable<T>> void selectionSort(T[] arr) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) 
            {
                if (arr[j].compareTo(arr[minIndex]) < 0) 
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) 
            {
                if (comparator.compare(arr[j], arr[minIndex]) < 0) 
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] arr) 
    {
        if (arr.length > 1) 
        {
            int mid = arr.length / 2;
            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, Comparator<T> comparator) 
    {
        if (arr.length > 1) 
        {
            int mid = arr.length / 2;
            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(arr, left, right, comparator);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] left, T[] right) 
    {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) 
        {
            if (left[i].compareTo(right[j]) <= 0) 
            {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) 
        {
            arr[k++] = left[i++];
        }
        while (j < right.length) 
        {
            arr[k++] = right[j++];
        }
    }

    private static <T> void merge(T[] arr, T[] left, T[] right, Comparator<T> comparator) 
    {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) 
        {
            if (comparator.compare(left[i], right[j]) <= 0) 
            {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) 
        {
            arr[k++] = left[i++];
        }
        while (j < right.length) 
        {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort
    public static <T extends Comparable<T>> void quickSort(T[] arr) 
    {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    public static <T> void quickSort(T[] arr, Comparator<T> comparator) 
    {
        quickSortHelper(arr, 0, arr.length - 1, comparator);
    }

    private static <T extends Comparable<T>> void quickSortHelper(T[] arr, int low, int high) 
    {
        if (low < high) 
        {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    private static <T> void quickSortHelper(T[] arr, int low, int high, Comparator<T> comparator) 
    {
        if (low < high) 
        {
            int pivotIndex = partition(arr, low, high, comparator);
            quickSortHelper(arr, low, pivotIndex - 1, comparator);
            quickSortHelper(arr, pivotIndex + 1, high, comparator);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) 
    {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) 
        {
            if (arr[j].compareTo(pivot) <= 0) 
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static <T> int partition(T[] arr, int low, int high, Comparator<T> comparator) 
    {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) 
        {
            if (comparator.compare(arr[j], pivot) <= 0) 
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Heap Sort
    /* Heap Sort is a comparison-based sorting algorithm that uses a binary heap data 
	*  structure to sort elements. The algorithm involves two main phases: building a
	*  max heap and repeatedly extracting the maximum element from the heap and 
    *  reconstructing the heap until all elements are sorted.
	*
    *  The build-max-heap operation takes O(n) time, and each heapify operation 
	*  takes O(log n) time. Since heapify is called n times, the total time complexity 
	*  is O(n log n).
	*/
 // 
    public static <T extends Comparable<T>> void heapSort(T[] arr) 
    {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i > 0; i--) 
        {
            // Move current root to end
            swap(arr, 0, i);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) 
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left].compareTo(arr[largest]) > 0) 
        {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right].compareTo(arr[largest]) > 0) 
        {
            largest = right;
        }

        // If largest is not root
        if (largest != i) 
        {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static <T> void heapSort(T[] arr, Comparator<T> comparator) 
    {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i, comparator);
        }

        // Heap sort
        for (int i = n - 1; i > 0; i--) 
        {
            // Move current root to end
            swap(arr, 0, i);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0, comparator);
        }
    }

    private static <T> void heapify(T[] arr, int n, int i, Comparator<T> comparator) 
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && comparator.compare(arr[left], arr[largest]) > 0) 
        {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && comparator.compare(arr[right], arr[largest]) > 0) 
        {
            largest = right;
        }

        // If largest is not root
        if (largest != i) 
        {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, comparator);
        }
    }
}
