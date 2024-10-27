import javax.swing.*;
import java.awt.*;

public class DataVisual {
    public static TablePanel tablePanel;
    public static DetailsPanel detailsPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Global Religion Data Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        detailsPanel = new DetailsPanel();
        tablePanel = new TablePanel(detailsPanel);

        frame.add(tablePanel);

        frame.add(detailsPanel);

        frame.setPreferredSize(new Dimension(800, 800));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);
    }
}