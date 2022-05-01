package report409416186.Algorithm;

public class MergeSort implements SortingAlgorithm{
    public static void Sort(int[] array) {
        Sort(array, 0, array.length - 1);
    }

    private static void Sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            Sort(array, left, mid);
            Sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //array1 => left ~ mid
        //array2 => mid+1 ~ right
        int[] tmpArr = new int[right + 1 - left];
        int i, j, k = 0;
        for (i = left, j = mid + 1; i <= mid && j <= right; ) {
            if (array[i] > array[j]) {
                tmpArr[k++] = array[j++];
            } else {
                tmpArr[k++] = array[i++];
            }
        }
        while (i <= mid) {
            tmpArr[k++] = array[i++];
        }
        while (j <= right) {
            tmpArr[k++] = array[j++];
        }
        for (i = left, j = 0; i <= right; i++) {
            array[i] = tmpArr[j++];
        }
    }
}
