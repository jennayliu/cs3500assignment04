import java.util.Objects;

/**
 * This is the implementation of the ImageModel interface.
 */
public class ImageModelImpl implements ImageModel {

  private final Image image; // I'm not sure if this should be an Image or a File
  private final ImageFunctionObject function;

  /**
   * This constructor takes in an image and a function object.
   * @param image The image, represented by an image class
   * @param function The ImageFunctionObject which decides what to do with the image
   */
  public ImageModelImpl(Image image, ImageFunctionObject function) {
    Objects.requireNonNull(image, "Image can't be null.");
    Objects.requireNonNull(function, "Function Object can't be null.");
    this.image = image;
    this.function = function;
  }

  @Override
  public void process(ImageFunctionObject modification) {
    function.apply(image);
  }

  @Override
  public void load() {

  }

  @Override
  public void save() {

  }
}
