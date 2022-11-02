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

  public PixelRGB[][] apply(PixelRGB[][] image) {
    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length; c ++) {
        image[r][c].red = image[r][c].red + this.value;
        image[r][c].green = image[r][c].green + this.value;
        image[r][c].blue = image[r][c].blue + this.value;
        if (image[r][c].red > image[r][c].getMax()) {
          image[r][c].red = image[r][c].getMax();
        }
        if (image[r][c].green > image[r][c].getMax()) {
          image[r][c].green = image[r][c].getMax();
        }
        if (image[r][c].blue > image[r][c].getMax()) {
          image[r][c].blue = image[r][c].getMax();
        }
      }
    }
    return image;
  }

}
