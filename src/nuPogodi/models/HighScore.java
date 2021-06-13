package nuPogodi.models;

import nuPogodi.utils.CSVReader;
import nuPogodi.utils.CSVWriter;

import java.util.ArrayList;
import java.util.Collections;


public class HighScore implements Comparable {
    private final String person;
    private final int score;
    private static final String filePath = "assets/leaderboard.csv";

    public HighScore(String person, int score){
        this.person = person;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getPerson() {
        return person;
    }

    public static ArrayList<HighScore> load(){
        CSVReader reader = new CSVReader(filePath);
        ArrayList<String[]> rows = reader.readRows();
        ArrayList<HighScore> list = new ArrayList<>();

        for(String[] row : rows){
            HighScore score =  new HighScore(row[0], Integer.parseInt(row[1]));
            list.add(score);
        }

        list.sort(Collections.reverseOrder());
        ArrayList<HighScore> top = new ArrayList<>();

        for (int i = 0; i < 8 && i < list.size(); i++)
            top.add(list.get(i));

        return top;
    }

    public static void writeScore(String person, int score){
        CSVWriter writer = new CSVWriter(filePath);
        String[] row = {person, String.valueOf(score)};
        writer.writeRow(row);
    }

    @Override
    public int compareTo(Object other) {
        HighScore otherScore = (HighScore) other;
        return (Integer.compare(this.getScore(), otherScore.getScore()));
    }
}
