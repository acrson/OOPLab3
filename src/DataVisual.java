import javax.swing.*;
import java.awt.*;

public class DataVisual {
    public static TablePanel tablePanel = new TablePanel();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Global Religion Data Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frame.add(tablePanel);

        frame.setPreferredSize(new Dimension(800, 800));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);
    }
}