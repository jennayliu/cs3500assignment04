package model;

/**
 * This interface represents the operations offered by the image processing
 * model.
 *
 */
public interface ImageRepo {

  public void add(String name, PixelRGB[][] image);
  /**
   * This method takes in an Model.ImageFunctionObject and applies it to the image.
   */
  public void process(ImageFunctionObject modification, String filename);

  // may or may not be needed
  enum RGBVIL { Red, Green, Blue, Value, Intensity, Luma};

  public void load(String filename);

  public void save(String filename, String newName);

}
