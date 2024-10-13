import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    public static void main(String[] args) {
        // CSV file path for data (relative path)
        String csvFilePath = "src/Data/Global Religion Dataset.csv";
        List<List<String>> sheet = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            sheet = br.lines()  // Converts lines to stream
                    .map(line -> {  // Maps each line to a list of values
                        String[] data = line.split(",");
                        List<String> row = new ArrayList<>();
                        for (String value : data) {
                            String newValue1 = value.replace(" ", "");
                            String newValue2 = newValue1.replace("\"", "");
                            row.add(newValue2);
                        }
                        return row; // Return the cleaned row
                    })
                    .collect(Collectors.toList());  // Collect into a List of Lists
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