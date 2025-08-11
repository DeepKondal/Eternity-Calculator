import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Simple Swing GUI for computing sinh(x) using the Taylor-series implementation.
 * <p>Design goals: clarity, accessibility, and no IDE dependency. Title shows the app version.</p>
 */
public class SinhGui extends JFrame {

  private static final long serialVersionUID = 1L;
  private static final String VERSION = "v1.0.0";

  private JTextField inputField;
  private JLabel resultLabel;

  /** Constructs the window, lays out widgets, and wires up actions. */
  public SinhGui() {
    setTitle("Eternity Calculator - sinh(x) " + VERSION);
    setSize(420, 220);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(true);

    JLabel prompt = new JLabel("Enter value for x:");
    prompt.setBounds(30, 30, 160, 25);
    add(prompt);

    inputField = new JTextField();
    inputField.setBounds(180, 30, 160, 25);
    add(inputField);

    JButton computeButton = new JButton("Compute sinh(x)");
    computeButton.setBounds(120, 70, 180, 30);
    add(computeButton);

    resultLabel = new JLabel("Result: ");
    resultLabel.setBounds(30, 120, 360, 25);
    add(resultLabel);

    // Accessibility & usability
    prompt.setLabelFor(inputField);
    inputField.setToolTipText("Enter a real number between -100 and 100.");
    computeButton.setToolTipText("Compute sinh(x) for the current input.");
    computeButton.setMnemonic(KeyEvent.VK_C);
    getRootPane().setDefaultButton(computeButton);

    prompt.getAccessibleContext().setAccessibleDescription("Label for input x.");
    inputField.getAccessibleContext()
        .setAccessibleDescription("Text field to enter x, range -100 to 100.");
    computeButton.getAccessibleContext()
        .setAccessibleDescription("Press to compute the hyperbolic sine of x.");
    resultLabel.getAccessibleContext()
        .setAccessibleDescription("Displays the computed result or an error message.");

    // Action: compute on click
    computeButton.addActionListener(new ActionListener() {
      @Override
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

  /**
   * Parses and validates the user input.
   *
   * @param text the raw text from the input field
   * @return the parsed double value
   * @throws InvalidInputException if the text is not a number or out of the accepted range
   */
  private double parseInput(String text) throws InvalidInputException {
    try {
      double val = Double.parseDouble(text);
      if (val < -100 || val > 100) {
        throw new InvalidInputException("Input out of range [-100, 100]");
      }
      return val;
    } catch (NumberFormatException ex) {
      throw new InvalidInputException("Please enter a valid number");
    }
  }

  /**
   * Application entry point.
   *
   * @param args ignored
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new SinhGui().setVisible(true));
  }
}
