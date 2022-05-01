package report409416186.Testing;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Random;

public class ArrayGenerator {

    private static final File ArrayFile = new File("C:\\SortingTest\\RandomArray.xml");
    public static final int genLen = 250000000;
    private static final int bound = 100000000;
    private static int[] src;

    public static int getLen() {
        return src.length;
    }

    public static void GenerateArrayAndSave() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ArrayFile));
            oos.writeObject(generate());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(oos).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void changeArrayLengthAndSave() {
        ObjectOutputStream oos = null;
        int[] change = new int[1000000000];
        try {
            oos = new ObjectOutputStream(Files.newOutputStream(ArrayFile.toPath()));
            System.arraycopy(src, 0, change, 0, 1000000000);
            oos.writeObject(change);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(oos).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(change.length);
    }

    private static int[] generate() {
        Random r = new Random();
        int[] res = new int[ArrayGenerator.genLen];
        for (int i = 0; i < ArrayGenerator.genLen; i++) {
            res[i] = r.nextInt(ArrayGenerator.bound);
        }
        return res;
    }

    public static void ReadRandomArray() {
        System.out.println("reading Array...");
        ObjectInputStream ois = null;
        int[] res = null;
        try {
            ois = new ObjectInputStream(Files.newInputStream(ArrayFile.toPath()));
            res = (int[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("read finished");
        src = res;
    }

    public static int[] getPartlyArray(int len) {
        int[] res = new int[len];
        System.arraycopy(src, 0, res, 0, len);
        return res;
    }
}
