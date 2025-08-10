import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Graphical User Interface for computing sinh(x) using SinhCalculator.
 */
public class SinhGui extends JFrame {

  private JTextField inputField;
  private JLabel resultLabel;

  /**
   * Constructs the SinhGui window.
   */
  public SinhGui() {
    setTitle("Eternity Calculator - sinh(x) v1.0.0");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(true);

    JLabel prompt = new JLabel("Enter value for x:");
    prompt.setBounds(30, 30, 120, 25);
    prompt.getAccessibleContext()
        .setAccessibleDescription("Label prompting user to enter a value for x");
    add(prompt);

    inputField = new JTextField();
    inputField.setBounds(160, 30, 150, 25);
    inputField.getAccessibleContext().setAccessibleDescription(
        "Text field to enter the x value for sinh calculation");
    add(inputField);

    JButton computeButton = new JButton("Compute sinh(x)");
    computeButton.setBounds(100, 70, 180, 30);
    computeButton.getAccessibleContext()
        .setAccessibleDescription("Button to compute the sinh(x) value");
    add(computeButton);

    resultLabel = new JLabel("Result: ");
    resultLabel.setBounds(30, 120, 320, 25);
    resultLabel.getAccessibleContext()
        .setAccessibleDescription("Displays the computed sinh(x) result");
    add(resultLabel);

    computeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          double x = parseInput(inputField.getText());
          double result = SinhCalculator.computeSinh(x);
          resultLabel.setText(
              String.format("Result: sinh(%.6f) = %.6f", x, result)
          );
        } catch (InvalidInputException ex) {
          resultLabel.setText("Error: " + ex.getMessage());
        }
      }
    });
  }

  /**
   * Parses and validates the input.
   *
   * @param text the user input as a string
   * @return parsed double value
   * @throws InvalidInputException if input is not valid or out of range
   */
  private double parseInput(String text) throws InvalidInputException {
    try {
      double val = Double.parseDouble(text);
      if (val < -100 || val > 100) {
        throw new InvalidInputException("Input out of range [-100, 100]");
      }
      return val;
    } catch (NumberFormatException e) {
      throw new InvalidInputException("Please enter a valid number");
    }
  }

  /**
   * Main method to launch the application.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new SinhGui().setVisible(true));
  }
}
