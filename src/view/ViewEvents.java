package view;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import model.ImageModel;

public interface ViewEvents {

  /**
   * An event that saves the image.
   * @param path The image path
   * @param newName The image name
   * @throws IOException If saving doesn't work
   */
  public void saveEvent(String path, String newName) throws IOException;

  /**
   * An event that loads the image.
   * @param path The image path
   * @param newName The image's new name
   * @throws NoSuchFileException If the file doesn't exist
   */
  public void loadEvent(String path, String newName) throws NoSuchFileException;

  /**
   * An event that brightens the image
   * @param amount The degree of brightening
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void brightenEvent(int amount, String imageName, String newName);

  public void ComponentEvent(ImageModel.RGBVIL rgbvil, String imageName, String newName);

  /**
   * An event that blurs the image.
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void BlurEvent(String imageName, String newName);

  /**
   * An event that flips the image horizontally.
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void FlipHEvent(String imageName, String newName);

  /**
   * An event that flips the image vertically.
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void FlipVEvent(String imageName, String newName);

  /**
   * An event that sharpens the image.
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void SharpenEvent(String imageName, String newName);

  /**
   * An event that makes the image sepia tone.
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void SepiaEvent(String imageName, String newName);

  /**
   * An event that grey scales the image.
   * @param imageName The existing image name
   * @param newName The changed image name
   */
  public void GreyscaleEvent(String imageName, String newName);


}
