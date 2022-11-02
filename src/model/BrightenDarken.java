package model;

/**
 * This class is used to darken images.
 */
public class BrightenDarken implements ImageFunctionObject {

  private final int value;
  private final boolean brightening;

  /**
   * The constructor sets how much we're darkening the image by.
   * @param value How much we're darkening the image by
   * @param brightening If true, we brighten. If false, we darken
   * @throws IllegalArgumentException If value is not positive
   */
  public BrightenDarken(int value, boolean brightening) throws IllegalArgumentException {
    if (value <= 0) {
      throw new IllegalArgumentException("Must be a positive number");
    }

    // if brightening is false, this means we're darkening
    // in other words, the value we're brightening by will be negative if we're darkening
    this.brightening = brightening;
    if (brightening) {
      this.value = value;
    } else {
      this.value = value * -1;
    }

  }

  @Override
  public PixelRGB[][] apply(PixelRGB[][] image) {
    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length; c ++) {
        image[r][c].red = image[r][c].red + this.value;
        image[r][c].green = image[r][c].green + this.value;
        image[r][c].blue = image[r][c].blue + this.value;

        // the following code make sures that brightening caps at the maxValue (usually 255)
        // and also the darkening doesn't go lower than 0
        if (image[r][c].red < 0) {
          image[r][c].red = 0;
        } else if (image[r][c].red > image[r][c].getMax()) {
          image[r][c].red = image[r][c].getMax();
        }
        if (image[r][c].green < 0) {
          image[r][c].green = 0;
        } else if (image[r][c].green > image[r][c].getMax()) {
          image[r][c].green = image[r][c].getMax();
        }
        if (image[r][c].blue < 0) {
          image[r][c].blue = 0;
        } else if (image[r][c].blue > image[r][c].getMax()) {
          image[r][c].blue = image[r][c].getMax();
        }
      }
    }
    return image;
  }
}
