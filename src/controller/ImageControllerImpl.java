package controller;

import java.io.IOException;
import java.util.Scanner;

import model.ImageFunctionObject;
import model.ImageRepo;

/**
 * This class is the implementation of the ImageController.
 */
public class ImageControllerImpl implements ImageController {

  private final ImageRepo model;
  private final Readable readable;
  private final Appendable appendable;

  /**
   * This constructor creates an instance of a controller.
   * @param model The model to work with
   * @param readable The readable to read from
   * @param appendable The appendable to transmit outputs
   * @throws IllegalArgumentException If any of the fields are null
   */
  public ImageControllerImpl(ImageRepo model, Readable readable, Appendable appendable)
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
}
