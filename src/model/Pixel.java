package model;

/**
 * This interface represents a pixel in an image.
 */
public interface Pixel {

  /**
   * This method returns the red value of the pixel.
   * @return The red value
   */
  public int getRed();

  /**
   * This method returns the green value of the pixel.
   * @return The green value
   */
  public int getGreen();

  /**
   * This method returns the green value of the pixel.
   * @return The green value
   */
  public int getBlue();

  /**
   * This method returns the max value of the pixel.
   * @return The max value
   */
  public int getMax();

  public void setRed();

  public void setGreen();

  public void setBlud();
}
