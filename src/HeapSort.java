import java.util.Arrays;

public class HeapSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        if (list == null || list.length <= 1) {
            return;
        }
        int n = list.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(list, 0, i);
            heapify(list, i, 0);
        }
    }
    private static <E extends Comparable<E>> void heapify(E[] list, int n, int root) {
        int smallest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left < n && list[left].compareTo(list[smallest]) < 0) {
            smallest = left;
        }
        if (right < n && list[right].compareTo(list[smallest]) < 0) {
            smallest = right;
        }
        if (smallest != root) {
            swap(list, root, smallest);
            heapify(list, n, smallest);
        }
    }
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] arr = {4, 10, 3, 5, 1};
        sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
