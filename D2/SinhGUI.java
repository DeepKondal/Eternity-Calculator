import javax.swing.*;
import java.awt.event.*;

public class SinhGUI extends JFrame {

    private JTextField inputField;
    private JLabel resultLabel;

    public SinhGUI() {
        setTitle("Eternity Calculator - sinh(x)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel prompt = new JLabel("Enter value for x:");
        prompt.setBounds(30, 30, 120, 25);
        add(prompt);

        inputField = new JTextField();
        inputField.setBounds(160, 30, 150, 25);
        add(inputField);

        JButton computeButton = new JButton("Compute sinh(x)");
        computeButton.setBounds(100, 70, 180, 30);
        add(computeButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(30, 120, 320, 25);
        add(resultLabel);

        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = parseInput(inputField.getText());
                    double result = SinhCalculator.computeSinh(x);
                    resultLabel.setText(String.format("Result: sinh(%.6f) = %.6f", x, result));
                } catch (InvalidInputException ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            }
        });
    }

    private double parseInput(String text) throws InvalidInputException {
        try {
            double val = Double.parseDouble(text);
            if (val < -100 || val > 100)
                throw new InvalidInputException("Input out of range [-100, 100]");
            return val;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid number");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SinhGUI().setVisible(true);
        });
    }
}
