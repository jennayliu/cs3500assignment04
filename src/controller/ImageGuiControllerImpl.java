package controller;


import java.io.IOException;

import model.ImageModel;
import view.ImageGuiView;
import view.ViewEvents;

/**
 * This class is the implementation of the ImageController.
 */
public class ImageGuiControllerImpl implements ImageGuiController, ViewEvents {

  private final ImageModel model;

  private final ImageGuiView view;

  /**
   * This constructor creates an instance of a controller.
   *
   * @param model The model to work with
   * @param view
   * @throws IllegalArgumentException If any of the fields are null
   */
  public ImageGuiControllerImpl(ImageModel model, ImageGuiView view)
          throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Can't have null fields.");
    }

    this.model = model;
    this.view = view;
    this.view.addViewListener(this);
  }

  @Override
  public void control() throws IOException {

  }

  @Override
  public void saveEvent(String name, String path) {

  }

  @Override
  public void loadEvent(String name) {

  }

  @Override
  public void brightenEvent(int amount) {

  }
}