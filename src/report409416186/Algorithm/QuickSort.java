package report409416186.Algorithm;

public class QuickSort implements SortingAlgorithm {


    public static void Sort(int[] array) {
        Sort(array, 0, array.length - 1);
    }

    private static void Sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[left + (right - left) / 2];
        int index = partition(array, left, right, pivot);
        Sort(array, left, index - 1);
        Sort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

}
