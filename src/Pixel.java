
// may or may not need this class
/**
 * This class represents a single pixel of an image, represented as RGB.
 */
public class Pixel {

  private final int red;
  private final int green;
  private final int blue;

  /**
   * The constructor which takes in a red, green, and blue value.
   * @param red The red value from 0-255
   * @param green The green value from 0-255
   * @param blue The blue value from 0-255
   * @throws IllegalArgumentException If any given value is out of range
   */
  public Pixel(int red, int green, int blue) throws IllegalArgumentException {

    if (red < 0 || green < 0 || blue < 0 || red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("Colors must be 0-255.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

}
