package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.ImageModel;
import model.PixelRGB;

/**
 * This class is the implementation of the ImageController.
 */
public class ImageControllerImpl implements ImageController {

  private final ImageModel model;
  private final Readable readable;
  private final Appendable appendable;

  /**
   * This constructor creates an instance of a controller.
   * @param model The model to work with
   * @param readable The readable to read from
   * @param appendable The appendable to transmit outputs
   * @throws IllegalArgumentException If any of the fields are null
   */
  public ImageControllerImpl(ImageModel model, Readable readable, Appendable appendable)
  throws IllegalArgumentException {
    if (model == null || readable == null || appendable == null) {
      throw new IllegalArgumentException("Can't have null fields.");
    }

    this.model = model;
    this.readable = readable;
    this.appendable = appendable;
  }

  @Override
  public void control() throws IOException {
    Scanner sc = new Scanner(this.readable);
    String command = sc.next();
    switch(command) {
      case("load"):
        break;
      case("save"):
        break;
      default:
        this.appendable.append("Unknown command.");
    }

  }

  private void save(PixelRGB[][] image, String filename) throws IOException {
    FileWriter filewriter = new FileWriter(filename);
    filewriter.append("P3" + System.lineSeparator());
    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length; c ++) {
        filewriter.append(image[r][c].getRed() + System.lineSeparator());
        filewriter.append(image[r][c].getGreen() + System.lineSeparator());
        filewriter.append(image[r][c].getBlue() + System.lineSeparator());
      }
    }



  }

}
