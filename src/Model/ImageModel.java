package Model;

/**
 * This interface represents the operations offered by the image processing
 * model.
 */
public interface ImageModel {


  /**
   * This method takes in an Model.ImageFunctionObject and applies it to the image.
   */
  public void process(ImageFunctionObject modification, String filename);

  // may or may not be needed
  enum color { Red, Green, Blue};

  public void load(String filename);

  public void save(String filename, String newName);

}
