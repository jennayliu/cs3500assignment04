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

        // we don't change this copy
        PixelRGB[][] copy = makeImageCopy2(image);

        // the logic behind this code is we set the values to be 0 at default if the pixel does not exist
        // (aka if the pixel is out of bounds)
        PixelRGB p1 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p2 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p3 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p4 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p5 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p6 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p7 = new PixelRGB(0, 0, 0, 255);
        PixelRGB p8 = new PixelRGB(0, 0, 0, 255);

        try {
          p1 = copy[r - 1][c - 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p2 = copy[r - 1][c];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p3 = copy[r - 1][c + 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p4 = copy[r][c - 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p5 = copy[r][c + 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p6 = copy[r + 1][c - 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p7 = copy[r + 1][c];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p8 = copy[r + 1][c + 1];
        } catch (IndexOutOfBoundsException e) {

        }

        image[r][c].setRed((int) (0.0625 * p1.getRed() + 0.125 * p2.getRed() + 0.0625 * p3.getRed()
                + 0.125 * p4.getRed() + 0.125 * p5.getRed()
                + 0.0625 * p6.getRed() + 0.125 * p7.getRed() + 0.0625 * p8.getRed()));
        image[r][c].setGreen((int) (0.0625 * p1.getGreen()
                + 0.125 * p2.getGreen() + 0.0625 * p3.getGreen()
                + 0.125 * p4.getGreen() + 0.125 * p5.getGreen()
                + 0.0625 * p6.getGreen() + 0.125 * p7.getGreen() + 0.0625 * p8.getGreen()));
        image[r][c].setBlue((int) (0.0625 * p1.getBlue()
                + 0.125 * p2.getBlue() + 0.0625 * p3.getBlue()
                + 0.125 * p4.getBlue() + 0.125 * p5.getBlue()
                + 0.0625 * p6.getBlue() + 0.125 * p7.getBlue() + 0.0625 * p8.getBlue()));

      }
    }
    return image;
  }

  public static PixelRGB[][] makeImageCopy2(PixelRGB[][] image) {
    PixelRGB[][] copy = new PixelRGB[image.length][image[0].length];
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
        copy[r][c] = image[r][c];
      }
    }
    return copy;
  }
}
