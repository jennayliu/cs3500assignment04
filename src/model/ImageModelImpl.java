package model;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

import model.command.ImageFunctionObject;

import static model.command.Blur.makeImageCopy2;

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
    String imageFormat = filename.split("\\.")[1];
    if (imageFormat.equals("ppm")) {
      if (ImageUtil.readPPM(filename) == null) {
        throw new NoSuchFileException("Invalid: no such file exist");
      } else {
        this.loadedImages.put(newName, ImageUtil.readPPM(filename));
      }
    } else {
      if (ImageUtil.readImage(filename) == null) {
        throw new NoSuchFileException("Invalid: no such file exist");
      } else {
        this.loadedImages.put(newName, ImageUtil.readPPM(filename));
      }
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
    return makeImageCopy2(image);
  }

}
