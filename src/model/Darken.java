package model;

/**
 * This class is used to darken images.
 */
public class Darken implements ImageFunctionObject {

  final protected int value;

  /**
   * The constructor sets how much we're darkening the image by.
   * @param value How much we're darkening the image by
   * @throws IllegalArgumentException If value is not positive
   */
  public Darken(int value) throws IllegalArgumentException {
    if (value <= 0) {
      throw new IllegalArgumentException("Must be a positive number");
    }
    this.value = value;
  }

  @Override
  public void apply(PixelRGB[][] image) {

  }
}
