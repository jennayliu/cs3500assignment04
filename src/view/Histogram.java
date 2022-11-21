package view;

import javax.swing.*;

import model.ImageModel;

/**
 * Image histograms show the frequency values of red, green, blue, or intensity in the pixels
 * of an image. This frequency is represented by a line graph.
 */
public class Histogram extends JPanel {

  private final ImageModel.RGBVIL type;

  public Histogram(ImageModel.RGBVIL type) throws IllegalArgumentException {
    super();
    if (type == ImageModel.RGBVIL.Value || type == ImageModel.RGBVIL.Luma) {
      throw new IllegalArgumentException("Must be red, green, blue, or intensity");
    }
    this.type = type;
  }

}
