package nuPogodi.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    private final String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String[]> readRows() {
        BufferedReader br;
        String line;
        FileReader reader;
        ArrayList<String[]> list = new ArrayList<>();

        try {
            reader = new FileReader(filePath);
            br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                list.add(row);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
