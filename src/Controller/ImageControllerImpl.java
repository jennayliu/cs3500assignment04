package Controller;

import Model.ImageModel;

/**
 * This class is the implementation of the ImageController.
 */
public class ImageControllerImpl {

  ImageModel model;
  Readable readable;
  Appendable appendable;

  public ImageControllerImpl(ImageModel model, Readable readable, Appendable appendable)
  throws IllegalArgumentException {
    if (model == null || readable == null || appendable == null) {
      throw new IllegalArgumentException("Can't have null fields.");
    }

    this.model = model;
    this.readable = readable;
    this.appendable = appendable;

  }
}
