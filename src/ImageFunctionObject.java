/**
 * This class represents a function object that can be used in the ImageModel to modify an image.
 */
public interface ImageFunctionObject {

  /**
   * This method modifies an image. This modification is based on the implementation.
   */
  public void apply(Image image);
}
