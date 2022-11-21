package controller;


import java.io.IOException;
import java.nio.file.NoSuchFileException;

import model.ImageModel;
import model.command.BrightenDarken;
import model.command.FlipHorizontal;
import model.command.Greyscale;
import model.command.ImageFunctionObject;
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
    this.view.initialize();
  }

  @Override
  public void control() throws IOException {

  }

  @Override
  public void saveEvent(String name, String path) throws IOException {
    this.model.save(path, name);
  }

  @Override
  public void loadEvent(String name, String path) throws NoSuchFileException {
    this.model.load(path, name);
    this.view.showCenterImage(name, this.model.getImage(name));

  }

  @Override
  public void brightenEvent(int amount, String imageName, String newName) {
    ImageFunctionObject functionObject = new BrightenDarken(amount);
    this.model.process(functionObject, imageName, newName);

  }

  @Override
  public void ComponentEvent(ImageModel.RGBVIL rgbvil, String imageName, String newName) {
    ImageFunctionObject functionObject = new Greyscale(rgbvil);
    this.model.process(functionObject, imageName, newName);
  }

  @Override
  public void BlurEvent(String imageName, String newName) {

  }

  @Override
  public void FlipHEvent(String imageName, String newName) {
    ImageFunctionObject functionObject = new FlipHorizontal();
    this.model.process(functionObject, imageName, newName);
  }

  @Override
  public void FlipVEvent(String imageName, String newName) {

  }

  @Override
  public void SharpenEvent(String imageName, String newName) {

  }

  @Override
  public void SepiaEvent(String imageName, String newName) {

  }

  @Override
  public void GreyscaleEvent(String imageName, String newName) {

  }


}