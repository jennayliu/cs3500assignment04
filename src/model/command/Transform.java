package model.command;

import model.PixelRGB;

public class Transform implements ImageFunctionObject {

  double[][] calculateMatrix;

  public Transform(double[][] calculateMatrix) {
    this.calculateMatrix = calculateMatrix;
  }

  @Override
  public PixelRGB[][] apply(PixelRGB[][] image) {
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
        // determines the greyscale color
        double[] pixelResult = new double[3];
        pixelResult[0] = this.calculateMatrix[0][0] * image[r][c].getRed() +
                this.calculateMatrix[0][1] * image[r][c].getGreen() +
                this.calculateMatrix[0][2] * image[r][c].getBlue();
        pixelResult[1] = this.calculateMatrix[1][0] * image[r][c].getRed() +
                this.calculateMatrix[1][1] * image[r][c].getGreen() +
                this.calculateMatrix[1][2] * image[r][c].getBlue();
        pixelResult[2] = this.calculateMatrix[2][0] * image[r][c].getRed() +
                this.calculateMatrix[2][1] * image[r][c].getGreen() +
                this.calculateMatrix[2][2] * image[r][c].getBlue();

        image[r][c].setRed((int) pixelResult[0]);
        image[r][c].setGreen((int) pixelResult[1]);
        image[r][c].setBlue((int) pixelResult[2]);
      }
    }

    return image;
  }
}
