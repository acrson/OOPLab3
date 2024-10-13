import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static void main(String[] args) {
        // CSV file path for data
        String csvFilePath = "C:/Users/carso/IdeaProjects/OOPLab3/src/Data/Global Religion Dataset.csv";
        List<List<String>> sheet = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] data = line.split(",");
                List<String> row = new ArrayList<>();
                for (String value : data) {
                    String newValue1 = value.replace(" ", "");
                    String newValue2 = newValue1.replace("\"", "");
                    row.add(newValue2);
                }
                sheet.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the CSV data
        for (List<String> row : sheet) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}