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
  public PixelRGB[][] apply(PixelRGB[][] image) {
    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length; c ++) {
        image[r][c].red = image[r][c].red - this.value;
        image[r][c].green = image[r][c].green - this.value;
        image[r][c].blue = image[r][c].blue - this.value;
        if (image[r][c].red < 0) {
          image[r][c].red = 0;
        }
        if (image[r][c].green < 0) {
          image[r][c].green = 0;
        }
        if (image[r][c].blue < 0) {
          image[r][c].blue = 0;
        }
      }
    }
    return image;
  }
}
