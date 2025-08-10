/**
 * Custom exception for invalid user input.
 */
public class InvalidInputException extends Exception {

  /**
   * Constructs a new InvalidInputException with the specified message.
   *
   * @param message description of the error
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
