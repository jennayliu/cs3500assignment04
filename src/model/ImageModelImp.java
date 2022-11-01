package model;

public class ImageModelImp implements ImageModel{
  private final Pixel[][] pixels;

  public ImageModelImp(Pixel[][] pixels) {
    this.pixels = pixels;

  }

  @Override
  public Pixel getPixel(int x, int y) {
    return pixels[x][y];
  }
}