package model.command;

import model.PixelRGB;

/**
 * This class is used to sharpen images.
 */
public class Sharpen implements ImageFunctionObject {

  /**
   * The default constructor, since it needs no fields.
   */
  public Sharpen() {
    // there is no code as no fields are needed
  }

  @Override
  public PixelRGB[][] apply(PixelRGB[][] image) {

    // this for loop scans all the pixels of an image, but it also has different cases for
    // each pixel on the "sides" of the image
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
      }
    }
    return image;
  }
}
