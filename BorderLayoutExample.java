import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

    public BorderLayoutExample() {
        super("BorderLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Initial size of the frame
        setLocationRelativeTo(null);

        // Create a panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Create and add components to different regions
        JButton northButton = new JButton("North");
        mainPanel.add(northButton, BorderLayout.NORTH);

        JButton southButton = new JButton("South");
        mainPanel.add(southButton, BorderLayout.SOUTH);

        JButton eastButton = new JButton("East");
        mainPanel.add(eastButton, BorderLayout.EAST);

        JButton westButton = new JButton("West");
        mainPanel.add(westButton, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            centerPanel.add(new JButton("Button " + i));
        }
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BorderLayoutExample::new);
    }
}
