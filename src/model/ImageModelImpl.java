package model;

import java.util.HashMap;
import java.util.Map;

import model.command.ImageFunctionObject;

/**
 * This is the implementation of the Model.ImageModel interface.
 */
public class ImageModelImpl implements ImageModel {

  private final Map<String, PixelRGB[][]> loadedImages;

  /**
   * This constructor takes in an image and a function object.
   * @param image The image, represented by an image class
   * @param function The Model.ImageFunctionObject which decides what to do with the image
   */
  public ImageModelImpl() {
    this.loadedImages = new HashMap<>();
  }

  @Override
  public void add(String name, PixelRGB[][] image) {

  }

  @Override
  public void process(ImageFunctionObject modification, String imageName, String newName) {
    PixelRGB[][] copy = makeImageCopy(loadedImages.get(imageName));
    this.loadedImages.put(newName, modification.apply(copy));
  }

  @Override
  public void load(String filename, String newName) {
    this.loadedImages.put(newName, ImageUtil.readPPM(filename));
  }

  @Override
  public void save(String imageName, String newName) {

  }

  @Override
  public PixelRGB[][] getImage(String imageName) {

    return makeImageCopy(loadedImages.get(imageName));
  }

  // this helper makes a copy of an image
  private PixelRGB[][] makeImageCopy(PixelRGB[][] image) {
    PixelRGB[][] copy = new PixelRGB[image.length][image[0].length];
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c ++) {
        copy[r][c] = image[r][c];
      }
    }
    return copy;
  }

}
