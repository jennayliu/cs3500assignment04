package model;

/**
 * This interface represents a pixel in an image.
 */
public interface Pixel {

  /**
   * This method returns the red value of the pixel.
   *
   * @return The red value
   */
  public int getRed();

  /**
   * This method returns the green value of the pixel.
   *
   * @return The green value
   */
  public int getGreen();

  /**
   * This method returns the green value of the pixel.
   *
   * @return The green value
   */
  public int getBlue();

  /**
   * This method returns the max value of the pixel.
   *
   * @return The max value
   */
  public int getMax();

  /**
   * This method set the red of pixel to give value.
   *
   * @param red the value of red
   */
  public void setRed(int red);

  /**
   * This method set the green of pixel to give value.
   *
   * @param green the value of green
   */
  public void setGreen(int green);

  /**
   * This method set the blue of pixel to give value.
   *
   * @param blue the value of blue
   */
  public void setBlue(int blue);
}
