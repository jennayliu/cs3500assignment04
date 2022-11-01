package controller;

import model.ImageRepo;

/**
 * This class is the implementation of the ImageController.
 */
public class ImageControllerImpl {

  ImageRepo model;
  Readable readable;
  Appendable appendable;

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
}
