/**
 * This interface represents the operations offered by the image processing
 * model.
 */
public interface ImageModel {


  /**
   * This method takes in an ImageFunctionObject and applies it to the image.
   */
  public void process(ImageFunctionObject modification);

  // may or may not be needed
  enum color { Red, Green, Blue};

  public void load();

  public void save();

}
