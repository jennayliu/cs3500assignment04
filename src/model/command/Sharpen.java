package model.command;

import model.ImageUtil;
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

        // we don't change this copy
        PixelRGB[][] copy = ImageUtil.makeImageCopy(image);

        // the logic behind this code is we set the values to be 0 at default if the pixel does not exist
        // (aka if the pixel is out of bounds)
        PixelRGB[] p = new PixelRGB[25];
        for (int i = 0; i < 25; i++) {
          p[i] = new PixelRGB(0, 0, 0, 255);
        }

        try {
          p[1] = copy[r - 2][c - 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[2] = copy[r - 2][c - 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[3] = copy[r - 2][c];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[4] = copy[r - 2][c + 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[5] = copy[r - 2][c + 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[6] = copy[r - 1][c - 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[7] = copy[r - 1][c - 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[8] = copy[r - 1][c];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[9] = copy[r - 1][c + 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p[10] = copy[r - 1][c + 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[11] = copy[r][c - 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[12] = copy[r][c - 1];
        } catch (IndexOutOfBoundsException e) {

        }

        p[13] = copy[r][c];

        try {
          p[14] = copy[r][c + 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[15] = copy[r][c + 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[16] = copy[r + 1][c - 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[17] = copy[r + 1][c - 1];
        } catch (IndexOutOfBoundsException e) {

        }
        try {
          p[18] = copy[r + 1][c];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[19] = copy[r + 1][c + 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[20] = copy[r + 1][c + 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[21] = copy[r + 2][c - 2];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[22] = copy[r + 2][c - 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[23] = copy[r + 2][c];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[24] = copy[r + 2][c + 1];
        } catch (IndexOutOfBoundsException e) {

        } try {
          p[25] = copy[r + 2][c + 2];
        } catch (IndexOutOfBoundsException e) {

        }



        image[r][c].setRed((int) (-0.125 * (p[1].getRed() + p[2].getRed() + p[3].getRed()
                + p[4].getRed() + p[5].getRed()
                + p[6].getRed() + p[10].getRed() + p[11].getRed() + p[15].getRed() + p[16].getRed()
                + p[20].getRed() + p[21].getRed()
                + p[22].getRed() + p[23].getRed() + p[24].getRed())
                + 0.25 * (p[7].getRed() + p[8].getRed()
                + p[9].getRed() + p[12].getRed() + p[14].getRed()
                + p[17].getRed() + p[18].getRed() + p[19].getRed())) + p[13].getRed());
        image[r][c].setGreen((int) (-0.125 * (p[1].getGreen() + p[2].getGreen() + p[3].getGreen()
                + p[4].getGreen() + p[5].getGreen()
                + p[6].getGreen() + p[10].getGreen() + p[11].getGreen()
                + p[15].getGreen() + p[16].getGreen()
                + p[20].getGreen() + p[21].getGreen()
                + p[22].getGreen() + p[23].getGreen() + p[24].getGreen())
                + 0.25 * (p[7].getRed() + p[8].getRed()
                + p[9].getRed() + p[12].getRed() + p[14].getRed()
                + p[17].getRed() + p[18].getRed() + p[19].getRed())) + copy[r][c].getRed());
        image[r][c].setBlue((int) (-0.125 * (p[1].getBlue() + p[2].getBlue() + p[3].getBlue()
                + p[4].getBlue() + p[5].getBlue()
                + p[6].getBlue() + p[10].getBlue() + p[11].getBlue()
                + p[15].getBlue() + p[16].getBlue()
                + p[20].getBlue() + p[21].getBlue()
                + p[22].getBlue() + p[23].getBlue() + p[24].getBlue())
                + 0.25 * (p[7].getBlue() + p[8].getBlue() + p[9].getBlue()
                + p[12].getBlue() + p[14].getBlue()
                + p[17].getBlue() + p[18].getBlue() + p[19].getBlue()) + copy[r][c].getBlue()));


      }
    }
    return image;
  }
}
