package model;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
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
   */
  public ImageModelImpl() {
    this.loadedImages = new HashMap<>();
  }


  @Override
  public void process(ImageFunctionObject modification, String imageName, String newName) {
    PixelRGB[][] copy = makeImageCopy(loadedImages.get(imageName));
    this.loadedImages.put(newName, modification.apply(copy));
  }

  @Override
  public void load(String filename, String newName) throws NoSuchFileException {
    if (ImageUtil.readPPM(filename) == null) {
      throw new NoSuchFileException("Invalid: no such file exist");
    } else {
      this.loadedImages.put(newName, ImageUtil.readPPM(filename));
    }

  }

  @Override
  public void save(String filenameToSave, String imageName) throws IOException {
    ImageUtil.writePPM(this.loadedImages.get(imageName), filenameToSave);
  }

  @Override
  public PixelRGB[][] getImage(String imageName) {

    return makeImageCopy(loadedImages.get(imageName));
  }

  // this helper makes a copy of an image
  private PixelRGB[][] makeImageCopy(PixelRGB[][] image) {
    PixelRGB[][] copy = new PixelRGB[image.length][image[0].length];
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
        copy[r][c] = image[r][c];
      }
    }
    return copy;
  }

}
