package model.command;

import model.PixelRGB;

/**
 * This class is used to darken images.
 */
public class BrightenDarken implements ImageFunctionObject {

  private final int value;
  private final boolean brightening; // THIS MIGHT BE BETTER REPRESENTED BY AN ENUM?

  /**
   * The constructor sets how much we're darkening the image by.
   * @param value How much we're darkening the image by
   * @param brightening If true, we brighten. If false, we darken
   * @throws IllegalArgumentException If value is not positive
   */
  public BrightenDarken(int value, boolean brightening) throws IllegalArgumentException {

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
        image[r][c].setRed(image[r][c].getRed() + this.value);
        image[r][c].setGreen(image[r][c].getGreen() + this.value);
        image[r][c].setBlue(image[r][c].getBlue() + this.value);

        // the following code make sures that brightening caps at the maxValue (usually 255)
        // and also the darkening doesn't go lower than 0
        if (image[r][c].getRed() < 0) {
          image[r][c].setRed(0);
        } else if (image[r][c].getRed() > image[r][c].getMax()) {
          image[r][c].setRed(image[r][c].getMax());
        }
        if (image[r][c].getGreen() < 0) {
          image[r][c].setGreen(0);
        } else if (image[r][c].getGreen() > image[r][c].getMax()) {
          image[r][c].setGreen(image[r][c].getMax());
        }
        if (image[r][c].getBlue() < 0) {
          image[r][c].setBlue(0);
        } else if (image[r][c].getBlue() > image[r][c].getMax()) {
          image[r][c].setBlue(image[r][c].getMax());
        }
      }
    }
    return image;
  }
}
