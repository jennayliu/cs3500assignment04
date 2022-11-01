package model;

/**
 * This class is used to greyscale images based on red, green, blue, value, intensity, or luma.
 */
public class Greyscale implements ImageFunctionObject {

  private final ImageRepo.RGBVIL rgbvil;

  /**
   * This constructor decides what kind of greyscale we're doing.
   * @param rgbvil
   */
  public Greyscale(ImageRepo.RGBVIL rgbvil) {
    this.rgbvil = rgbvil;
  }

  @Override
  public void apply(PixelRGB[][] image) throws IllegalArgumentException {
    int greyValue = 0;
    switch(this.rgbvil) {
      case Red:
        break;
      case Green:
        break;
      case Blue:
        break;
      case Value:
        break;
      case Intensity:
        break;
      case Luma:
        break;
      default:
        throw new IllegalArgumentException("Not a valid RGBVIL.");
    }

  }
}
