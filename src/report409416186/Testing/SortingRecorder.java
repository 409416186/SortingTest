package report409416186.Testing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SortingRecorder {
    private final BufferedWriter bw;
    private FileWriter fw;

    public SortingRecorder(String Path) {
        File record = new File(Path);
        if (!record.getParentFile().exists()) {
            if (!record.getParentFile().mkdirs()) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            fw = new FileWriter(record);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bw = new BufferedWriter(fw);
    }

    public void addInFile(long time) {
        try {
            bw.write(Long.toString(time));
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        assert bw != null;
        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
