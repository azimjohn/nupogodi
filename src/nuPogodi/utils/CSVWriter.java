package nuPogodi.utils;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private final String filePath;

    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeRow(String[] row) {
        String line = String.join(",", row);
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(line);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
