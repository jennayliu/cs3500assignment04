package model.command;

import model.PixelRGB;

/**
 * This class is used to flip images vertically.
 */
public class FlipVertical implements ImageFunctionObject {
  @Override
  public PixelRGB[][] apply(PixelRGB[][] image) {

    for (int r = 0; r < image[0].length / 2; r++) {
      for (int c = 0; c < image.length; c ++) {
        image[r][c] = image[image[0].length - 1 - r][c];
      }
    }

    return image;
  }
}
