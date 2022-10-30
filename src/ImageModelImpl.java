import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This is the implementation of the ImageModel interface.
 */
public class ImageModelImpl implements ImageModel {
  private final ImageFunctionObject function;
  private final Map<String, Image> loadedImages;

  /**
   * This constructor takes in an image and a function object.
   * @param image The image, represented by an image class
   * @param function The ImageFunctionObject which decides what to do with the image
   */
  public ImageModelImpl(ImageFunctionObject function) {
    Objects.requireNonNull(function, "Function Object can't be null.");
    this.function = function;
    this.loadedImages = new HashMap<String, Image>();
  }

  @Override
  public void process(ImageFunctionObject modification, String filename) {
    this.function.apply(loadedImages.get(filename));
  }

  @Override
  public void load(String filename) {
    this.loadedImages.put(filename, new Image(filename));
  }

  @Override
  public void save(String filename, String newName) {

  }
}
