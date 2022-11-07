package model.command;

import model.PixelRGB;

/**
 * This class is used to blur images.
 */
public class Blur implements ImageFunctionObject {

  /**
   * The default constructor, since it needs no fields.
   */
  public Blur() {
    // there is no code as no fields are needed
  }

  @Override
  public PixelRGB[][] apply(PixelRGB[][] image) {

    // this for loop scans all the pixels of an image, but it also has different cases for
    // each pixel on the "sides" of the image
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
        if (r == 0) {
          if (c == 0) {
            // the top left corner

          } else if (c == image[0].length - 1) {
            // the bottom left corner

          } else {
            // the left side, excluding corners

          }
        } else if (r == image.length - 1) {
          if (c == 0) {
            // the top right corner

          } else if (c == image[0].length - 1) {
            // the bottom right corner

          } else {
            // the right side, excluding corners

          }
        } else if (c == 0) {
          // the top side

        } else if (c == image[0].length - 1) {
          // the bottom side

        } else {
          // any pixel not on the side

        }
      }
    }
    return image;
  }
}
