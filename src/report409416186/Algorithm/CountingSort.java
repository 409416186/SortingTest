package report409416186.Algorithm;

public class CountingSort implements SortingAlgorithm{
    public static void Sort(int[] array) {
        if (array == null || array.length == 0) return;
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int[] bucket = new int[max - min + 1];
        for (int n : array) {
            bucket[n - min]++;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            int amount = bucket[i];
            for (int j = 0; j < amount; j++) {
                array[k++] = i + min;
            }
        }
    }
}
