package report409416186.Testing;

import report409416186.Algorithm.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    public static void main(String[] args) {
        ArrayGenerator.ReadRandomArray();
        test(QuickSort.class, "G:\\Test\\quick", 0, 250000000, 100000);
        test(MergeSort.class, "G:\\Test\\merge", 0, 250000000, 100000);
        test(HeapSort.class, "G:\\Test\\heap", 0, 250000000, 100000);
        test(CountingSort.class, "G:\\Test\\count", 0, 250000000, 100000);
    }

    public static void test(Class<? extends SortingAlgorithm> sortingClazz, String dir, int start, int end, int testPer) {
        Method sort;
        try {
            sort = sortingClazz.getMethod("Sort", int[].class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        String algorithm = sortingClazz.getSimpleName().toLowerCase();
        SortingRecorder ran_rec = new SortingRecorder(dir + "\\" + algorithm + "_random_" + start + "_to_" + end + "_per_" + testPer + ".txt");
        SortingRecorder sorted_rec = new SortingRecorder(dir + "\\" + algorithm + "_sorted_" + start + "_to_" + end + "_per_" + testPer + ".txt");
        SortingRecorder sorted_rev_rec = new SortingRecorder(dir + "\\" + algorithm + "_sorted_reverse_" + start + "_to_" + end + "_per_" + testPer + ".txt");
        int len = 0;
        while (len <= ArrayGenerator.genLen) {
            //random
            try {
                int[] partlyArray = ArrayGenerator.getPartlyArray(len);
                len += testPer;
                Timer ran = new Timer();
                ran.start();
                sort.invoke(null, partlyArray);
                ran_rec.addInFile(ran.end());
                //sorted
                Timer sorted = new Timer();
                sorted.start();
                sort.invoke(null, partlyArray);
                sorted_rec.addInFile(sorted.end());
                //sorted reverse
                reverse(partlyArray);
                Timer reverse_sorted = new Timer();
                reverse_sorted.start();
                sort.invoke(null, partlyArray);
                sorted_rev_rec.addInFile(reverse_sorted.end());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        ran_rec.saveFile();
        sorted_rec.saveFile();
        sorted_rev_rec.saveFile();
    }

    private static void reverse(int[] array) {
        int temp;
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
