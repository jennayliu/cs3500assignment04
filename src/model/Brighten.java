package model;

/**
 * This class is used to brighten images.
 */
public class Brighten implements ImageFunctionObject {

  private final int amount;

  /**
   * The constructor which sets the given amount.
   * @param amount How much to brighten the image by
   */
  public Brighten(int amount) {
    this.amount = amount;
  }
  @Override
  public void apply(Pixel[][] image) {
    // code that brightens the image
  }
}
