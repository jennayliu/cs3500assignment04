package model;

import model.command.ImageFunctionObject;

/**
 * This interface represents the operations offered by the image processing
 * model.
 *
 */
public interface ImageModel {

  public void add(String name, PixelRGB[][] image);
  /**
   * This method takes in an Model.ImageFunctionObject and applies it to the image.
   * Then, it adds the modified image to the HashMap with a new name.
   */
  public void process(ImageFunctionObject modification, String imageName, String newName);

  // may or may not be needed
  enum RGBVIL { Red, Green, Blue, Value, Intensity, Luma};

  public void load(String filename, String newName);

  public void save(String imageName, String newName);

  public PixelRGB[][] getImage(String imageName);

}
