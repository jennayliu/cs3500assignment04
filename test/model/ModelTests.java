package model;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.NoSuchFileException;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.ImageModel;
import model.ImageModelImpl;
import model.command.BrightenDarken;
import model.command.FlipHorizontal;
import model.command.FlipVertical;
import model.command.Greyscale;
import model.command.ImageFunctionObject;

import static org.junit.Assert.assertEquals;

/**
 * This class contains tests related to the model.
 */
public class ModelTests {

  // tests if every pixel in a 2x2 completely black image loaded correctly
  @Test
  public void testLoad() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("black.ppm", "black");
    for (int r = 0; r < model.getImage("black")[0].length; r++) {
      for (int c = 0; c < model.getImage("black").length; c++) {
        assertEquals(0, model.getImage("black")[r][c].getRed());
        assertEquals(0, model.getImage("black")[r][c].getGreen());
        assertEquals(0, model.getImage("black")[r][c].getBlue());
      }
    }
  }


  @Test (expected = NoSuchFileException.class)
  public void testLoadException() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("noSuchFile", "black");

  }

  // testing all of the function objects

  @Test
  public void testBrightenDarken() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("checkerboardbw.ppm", "checker");

    // the after state for brightening
    ImageFunctionObject brighten = new BrightenDarken(1);
    model.process(brighten, "checker", "checker-bright");
    assertEquals(1, model.getImage("checker-bright")[0][0].getRed());
    assertEquals(1, model.getImage("checker-bright")[0][0].getGreen());
    assertEquals(1, model.getImage("checker-bright")[0][0].getBlue());
    assertEquals(255, model.getImage("checker-bright")[0][0].getMax());
    assertEquals(255, model.getImage("checker-bright")[0][1].getRed());
    assertEquals(255, model.getImage("checker-bright")[0][1].getGreen());
    assertEquals(255, model.getImage("checker-bright")[0][1].getBlue());
    assertEquals(255, model.getImage("checker-bright")[0][1].getMax());
    assertEquals(1, model.getImage("checker-bright")[1][0].getRed());
    assertEquals(1, model.getImage("checker-bright")[1][0].getGreen());
    assertEquals(1, model.getImage("checker-bright")[1][0].getBlue());
    assertEquals(255, model.getImage("checker-bright")[1][0].getMax());
    assertEquals(255, model.getImage("checker-bright")[1][1].getRed());
    assertEquals(255, model.getImage("checker-bright")[1][1].getGreen());
    assertEquals(255, model.getImage("checker-bright")[1][1].getBlue());
    assertEquals(255, model.getImage("checker-bright")[1][1].getMax());
    // the after state for darkening
    ImageFunctionObject darken = new BrightenDarken(-1);
    model.process(darken, "checker", "checker-dark");
    assertEquals(0, model.getImage("checker-dark")[0][0].getRed());
    assertEquals(0, model.getImage("checker-dark")[0][0].getGreen());
    assertEquals(0, model.getImage("checker-dark")[0][0].getBlue());
    assertEquals(255, model.getImage("checker-dark")[0][0].getMax());
    assertEquals(254, model.getImage("checker-dark")[0][1].getRed());
    assertEquals(254, model.getImage("checker-dark")[0][1].getGreen());
    assertEquals(254, model.getImage("checker-dark")[0][1].getBlue());
    assertEquals(255, model.getImage("checker-dark")[0][1].getMax());
    assertEquals(0, model.getImage("checker-dark")[1][0].getRed());
    assertEquals(0, model.getImage("checker-dark")[1][0].getGreen());
    assertEquals(0, model.getImage("checker-dark")[1][0].getBlue());
    assertEquals(255, model.getImage("checker-dark")[0][1].getMax());
    assertEquals(254, model.getImage("checker-dark")[1][1].getRed());
    assertEquals(254, model.getImage("checker-dark")[1][1].getGreen());
    assertEquals(254, model.getImage("checker-dark")[1][1].getBlue());
    assertEquals(255, model.getImage("checker-dark")[1][1].getMax());
  }

  @Test
  public void testFlipH() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("1black1white.ppm", "checker");
    ImageFunctionObject flipH = new FlipHorizontal();
    model.process(flipH, "checker", "checkerH");
    assertEquals(255, model.getImage("checkerH")[0][0].getRed());
    assertEquals(255, model.getImage("checkerH")[0][0].getGreen());
    assertEquals(255, model.getImage("checkerH")[0][0].getBlue());
    assertEquals(255, model.getImage("checkerH")[0][0].getMax());
    assertEquals(0, model.getImage("checkerH")[0][1].getRed());
    assertEquals(0, model.getImage("checkerH")[0][1].getGreen());
    assertEquals(0, model.getImage("checkerH")[0][1].getBlue());
    assertEquals(255, model.getImage("checkerH")[0][1].getMax());
  }

  @Test
  public void testFlipV() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("1black1whiteVertical.ppm", "checker");
    ImageFunctionObject flipV = new FlipVertical();
    model.process(flipV, "checker", "checkerV");
    assertEquals(255, model.getImage("checkerV")[0][0].getRed());
    assertEquals(255, model.getImage("checkerV")[0][0].getGreen());
    assertEquals(255, model.getImage("checkerV")[0][0].getBlue());
    assertEquals(255, model.getImage("checkerV")[0][0].getMax());
    assertEquals(0, model.getImage("checkerV")[1][0].getRed());
    assertEquals(0, model.getImage("checkerV")[1][0].getGreen());
    assertEquals(0, model.getImage("checkerV")[1][0].getBlue());
    assertEquals(255, model.getImage("checkerV")[1][0].getMax());
  }

  /*
  TestImageWith4Pixels.ppm
  Width of image: 2
  Height of image: 2
  Maximum value of a color in this file (usually 255): 255
  Color of pixel (0,0): 101,90,58
  Color of pixel (1,0): 103,120,62
  Color of pixel (0,1): 110,110,110
  Color of pixel (1,1): 146,118,150
  */

  @Test
  public void testGreyscaleRed() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject redGrayscale = new Greyscale(ImageModel.RGBVIL.Red);
    model.process(redGrayscale, "checker", "GrayscaleRed");

    assertEquals(101, model.getImage("GrayscaleRed")[0][0].getRed());
    assertEquals(101, model.getImage("GrayscaleRed")[0][0].getGreen());
    assertEquals(101, model.getImage("GrayscaleRed")[0][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleRed")[0][0].getMax());
    assertEquals(146, model.getImage("GrayscaleRed")[1][1].getRed());
    assertEquals(146, model.getImage("GrayscaleRed")[1][1].getGreen());
    assertEquals(146, model.getImage("GrayscaleRed")[1][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleRed")[1][1].getMax());
  }

  @Test
  public void testGreyscaleGreen() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject greenGrayscale = new Greyscale(ImageModel.RGBVIL.Green);
    model.process(greenGrayscale, "checker", "GrayscaleGreen");

    assertEquals(90, model.getImage("GrayscaleGreen")[0][0].getRed());
    assertEquals(90, model.getImage("GrayscaleGreen")[0][0].getGreen());
    assertEquals(90, model.getImage("GrayscaleGreen")[0][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleGreen")[0][0].getMax());
    assertEquals(118, model.getImage("GrayscaleGreen")[1][1].getRed());
    assertEquals(118, model.getImage("GrayscaleGreen")[1][1].getGreen());
    assertEquals(118, model.getImage("GrayscaleGreen")[1][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleGreen")[1][1].getMax());
  }

  @Test
  public void testGreyscaleBlue() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject blueGrayscale = new Greyscale(ImageModel.RGBVIL.Blue);
    model.process(blueGrayscale, "checker", "GrayscaleBlue");

    assertEquals(58, model.getImage("GrayscaleBlue")[0][0].getRed());
    assertEquals(58, model.getImage("GrayscaleBlue")[0][0].getGreen());
    assertEquals(58, model.getImage("GrayscaleBlue")[0][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleBlue")[0][0].getMax());
    assertEquals(150, model.getImage("GrayscaleBlue")[1][1].getRed());
    assertEquals(150, model.getImage("GrayscaleBlue")[1][1].getGreen());
    assertEquals(150, model.getImage("GrayscaleBlue")[1][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleBlue")[1][1].getMax());
  }

  @Test
  public void testGreyscaleValue() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject valueGrayscale = new Greyscale(ImageModel.RGBVIL.Value);
    model.process(valueGrayscale, "checker", "GrayscaleValue");

    // when value of red is the biggest in single pixel
    assertEquals(101, model.getImage("GrayscaleValue")[0][0].getRed());
    assertEquals(101, model.getImage("GrayscaleValue")[0][0].getGreen());
    assertEquals(101, model.getImage("GrayscaleValue")[0][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleValue")[0][0].getMax());

    // when value of green is the biggest in single pixel
    assertEquals(120, model.getImage("GrayscaleValue")[0][1].getRed());
    assertEquals(120, model.getImage("GrayscaleValue")[0][1].getGreen());
    assertEquals(120, model.getImage("GrayscaleValue")[0][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleValue")[0][1].getMax());

    // when value of blue is the biggest in single pixel
    assertEquals(150, model.getImage("GrayscaleValue")[1][1].getRed());
    assertEquals(150, model.getImage("GrayscaleValue")[1][1].getGreen());
    assertEquals(150, model.getImage("GrayscaleValue")[1][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleValue")[1][1].getMax());

    // when value three pixels are same
    assertEquals(110, model.getImage("GrayscaleValue")[1][0].getRed());
    assertEquals(110, model.getImage("GrayscaleValue")[1][0].getGreen());
    assertEquals(110, model.getImage("GrayscaleValue")[1][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleValue")[1][0].getMax());
  }

  @Test
  public void testGreyscaleIntensity() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject IntensityGrayscale = new Greyscale(ImageModel.RGBVIL.Intensity);
    model.process(IntensityGrayscale, "checker", "GrayscaleIntensity");

    assertEquals(83, model.getImage("GrayscaleIntensity")[0][0].getRed());
    assertEquals(83, model.getImage("GrayscaleIntensity")[0][0].getGreen());
    assertEquals(83, model.getImage("GrayscaleIntensity")[0][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleIntensity")[0][0].getMax());

    assertEquals(138, model.getImage("GrayscaleIntensity")[1][1].getRed());
    assertEquals(138, model.getImage("GrayscaleIntensity")[1][1].getGreen());
    assertEquals(138, model.getImage("GrayscaleIntensity")[1][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleIntensity")[1][1].getMax());
  }

  @Test
  public void testGreyscaleLuma() throws NoSuchFileException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject IntensityGrayscale = new Greyscale(ImageModel.RGBVIL.Luma);
    model.process(IntensityGrayscale, "checker", "GrayscaleLuma");
    assertEquals(90, model.getImage("GrayscaleLuma")[0][0].getRed());
    assertEquals(90, model.getImage("GrayscaleLuma")[0][0].getGreen());
    assertEquals(90, model.getImage("GrayscaleLuma")[0][0].getBlue());
    assertEquals(255, model.getImage("GrayscaleLuma")[0][0].getMax());

    assertEquals(126, model.getImage("GrayscaleLuma")[1][1].getRed());
    assertEquals(126, model.getImage("GrayscaleLuma")[1][1].getGreen());
    assertEquals(126, model.getImage("GrayscaleLuma")[1][1].getBlue());
    assertEquals(255, model.getImage("GrayscaleLuma")[0][0].getMax());
  }

  @Test
  public void testSave() throws IOException {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checkerOriginal");
    model.save("TestingSaveImage.ppm", "checkerOriginal");
    model.load("TestingSaveImage.ppm", "checkerAfterSave");

    assertEquals(model.getImage("checkerOriginal")[0][0].getRed(),
            model.getImage("checkerAfterSave")[0][0].getRed());
    assertEquals(model.getImage("checkerOriginal")[0][0].getGreen(),
            model.getImage("checkerAfterSave")[0][0].getGreen());
    assertEquals(model.getImage("checkerOriginal")[0][0].getBlue(),
            model.getImage("checkerAfterSave")[0][0].getBlue());
    assertEquals(model.getImage("checkerOriginal")[0][0].getMax(),
            model.getImage("checkerAfterSave")[0][0].getMax());

    assertEquals(model.getImage("checkerOriginal")[1][1].getRed(),
            model.getImage("checkerAfterSave")[1][1].getRed());
    assertEquals(model.getImage("checkerOriginal")[1][1].getGreen(),
            model.getImage("checkerAfterSave")[1][1].getGreen());
    assertEquals(model.getImage("checkerOriginal")[1][1].getBlue(),
            model.getImage("checkerAfterSave")[1][1].getBlue());
    assertEquals(model.getImage("checkerOriginal")[1][1].getMax(),
            model.getImage("checkerAfterSave")[1][1].getMax());
  }
}
