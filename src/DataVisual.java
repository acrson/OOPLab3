import javax.swing.*;
import java.awt.*;

public class DataVisual {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Global Religion Data Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        TablePanel tablePanel = new TablePanel();
        frame.getContentPane().add(tablePanel);

        frame.setPreferredSize(new Dimension(800, 800));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);
    }
}