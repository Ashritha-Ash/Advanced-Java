package program4c;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClockButtonDemo extends JFrame implements ActionListener {

    JButton digitalButton, hourglassButton;
    JLabel messageLabel;

    public ClockButtonDemo() {
        setTitle("Clock Button Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load icons
        ImageIcon digitalIcon = new ImageIcon("clock.png.png");
        ImageIcon hourglassIcon = new ImageIcon("hourglass.png.png");

        // Create buttons
        digitalButton = new JButton(digitalIcon);
        hourglassButton = new JButton(hourglassIcon);

        // Add action listeners
        digitalButton.addActionListener(this);
        hourglassButton.addActionListener(this);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(digitalButton);
        buttonPanel.add(hourglassButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Label for message
        messageLabel = new JLabel("Press a button", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == digitalButton) {
            messageLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == hourglassButton) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        // Check if images are available
        if (!new java.io.File("clock.png.png").exists() || !new java.io.File("hourglass.png.png").exists()) {
            JOptionPane.showMessageDialog(null,
                "Could not load one or both images. Please check if 'clock.png' and 'hourglass.png' are in the project root.",
                "Image Load Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        new ClockButtonDemo();
    }
}
