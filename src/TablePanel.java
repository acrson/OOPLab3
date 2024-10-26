import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TablePanel extends JPanel {
    Data data; // Creates a data object from the data class
    // Creates a JTable
    JTable table;

    public TablePanel() {
        this.setPreferredSize(new Dimension(800, 400));
        this.setBackground(Color.BLUE);

        Data data = new Data();

        table = new JTable(data.getData(data), data.getColumnNames(data));

        // Disable automatic column resizing to allow horizontal scrolling
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Auto sizes the columns
        for (int i = 0; data.getData(data)[0].length > i; i++) { // Iterate through each column
            final int columnIndex = i; // Create a final variable for the current column index

            String longestString = Arrays.stream(data.getData(data))
                    .filter(row -> row.length > columnIndex) // Ensure row has the specified column
                    .map(row -> (String) row[columnIndex])            // Get the value in the specified column
                    .max(Comparator.comparingInt(String::length)) // Find the longest string
                    .orElse(""); // Return empty string if no valid string is found

            // Set the minimum width for the column based on the longest string found
            int minWidth = Math.max(60, longestString.length() * 10); // Calculate width based on length
            table.getColumnModel().getColumn(i).setMinWidth(minWidth);
            table.getColumnModel().getColumn(i).setPreferredWidth(minWidth);
        }

        JScrollPane scrollPane = new JScrollPane(table); // Add the table to the scroll pane
        scrollPane.setPreferredSize(new Dimension(800, 270)); // Set a preferred size for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        table.setFillsViewportHeight(true);

        add(scrollPane); // Add the scroll pane to the frame
    }
}