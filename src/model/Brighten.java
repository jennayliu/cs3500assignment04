package model;

/**
 * This class is used to brighten images.
 */
public class Brighten extends Darken implements ImageFunctionObject {

  /**
   * The constructor sets how much we're brightening the image by.
   *
   * @param value How much we're darkening the image by
   * @throws IllegalArgumentException If value is not positive
   */
  public Brighten(int value) throws IllegalArgumentException {
    super(value);
  }

  @Override
  public void apply(PixelRGB[][] image) {
    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length; c ++) {
        image[r][c].red = image[r][c].red + this.value;
      }
    }
  }
}
