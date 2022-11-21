package view;

import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import model.ImageModel;

/**
 * Image histograms show the frequency values of red, green, blue, or intensity in the pixels
 * of an image. This frequency is represented by a line graph.
 */
public class Histogram extends JPanel {

  private final ImageModel.RGBVIL type;
  private final int maxHeight;
  private final int[] data;

  public Histogram(ImageModel.RGBVIL type, int[] data) throws IllegalArgumentException {
    super();
    if (type == ImageModel.RGBVIL.Value || type == ImageModel.RGBVIL.Luma) {
      throw new IllegalArgumentException("Must be red, green, blue, or intensity");
    }

    this.type = type;
    this.data = data;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);

    // here we "flip" the y coordinate so that (0, 0) is bottom left
    AffineTransform originalTransform = g2d.getTransform();
    g2d.translate(0, this.getPreferredSize().getHeight());
    g2d.scale(1, -1);

    // the graph area
    g2d.drawRect(30, 30, 300, 300);


  }

}
