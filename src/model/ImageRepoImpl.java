package model;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the implementation of the Model.ImageModel interface.
 */
public class ImageRepoImpl implements ImageRepo {

  private final Map<String, PixelRGB[][]> loadedImages;

  /**
   * This constructor takes in an image and a function object.
   * @param image The image, represented by an image class
   * @param function The Model.ImageFunctionObject which decides what to do with the image
   */
  public ImageRepoImpl() {
    this.loadedImages = new HashMap<>();
  }

  @Override
  public void add(String name, PixelRGB[][] image) {

  }

  @Override
  public void process(ImageFunctionObject modification, String filename) {
    modification.apply(loadedImages.get(filename));
  }

  @Override
  public void load(String filename) {
    this.loadedImages.put(filename, ImageUtil.readPPM(filename));
  }

  @Override
  public void save(String filename, String newName) {

  }
}
