import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DetailsPanel extends JPanel {
    public List<JLabel> detailLabels;
    Data data;

    public DetailsPanel() {
        this.setPreferredSize(new Dimension(400, 750));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout());

        setLayout(new GridLayout(0, 4, 2, 2)); // Rows, Columns, Horizontal Gap, Vertical Gap


        detailLabels = new ArrayList<>();
    }

    // Method to update details based on selected row data
    public void updateDetails(Object[] rowData, int selectedColumn) {
        // Clear previous labels from the panel
        removeAll();
        detailLabels.clear();
        data = new Data();
        String[] columnName = data.getColumnNames(data);

        // Loop through each item in the row data
        for (int i = 0; i < rowData.length; i++) {
            // Create and add the label for each piece of data
            JLabel label = new JLabel( columnName[i] + ": ");
            label.setFont(new Font("Arial", Font.BOLD, 12));
            if (i == selectedColumn) {
                label.setOpaque(true); // Make the background visible
                label.setBackground(Color.YELLOW); // Set the background color to yellow
                label.setForeground(Color.BLACK); // Set text color to black
            }

            JLabel valueLabel = new JLabel(String.valueOf(rowData[i]));
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            if (i == selectedColumn) {
                valueLabel.setOpaque(true); // Make the background visible
                valueLabel.setBackground(Color.YELLOW); // Set the background color to yellow
                valueLabel.setForeground(Color.BLACK); // Set text color to black
            }
            detailLabels.add(label);
            detailLabels.add(valueLabel);

            add(label);
            add(valueLabel);
        }

        // Revalidate and repaint to reflect the changes immediately
        revalidate();
        repaint();
    }
}
