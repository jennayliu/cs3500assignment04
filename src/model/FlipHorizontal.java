package model;

/**
 * This class is used to flip images horizontally.
 */
public class FlipHorizontal implements ImageFunctionObject{
  @Override
  public PixelRGB[][] apply(PixelRGB[][] image) {

    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length / 2; c ++) {
        image[r][c] = image[r][image.length - 1 - c];
      }
    }

    return image;
  }
}
