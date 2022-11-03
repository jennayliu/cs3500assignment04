import org.junit.Test;

import java.io.StringReader;

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
  public void testLoad() {
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

  // testing all of the function objects

  @Test
  public void testBrightenDarken() {
    ImageModel model = new ImageModelImpl();
    model.load("checkerboardbw.ppm", "checker");

    // the after state for brightening
    ImageFunctionObject brighten = new BrightenDarken(1);
    model.process(brighten, "checker", "checker-bright");
    assertEquals(1, model.getImage("checker-bright")[0][0].getRed());
    assertEquals(1, model.getImage("checker-bright")[0][0].getGreen());
    assertEquals(1, model.getImage("checker-bright")[0][0].getBlue());
    assertEquals(255, model.getImage("checker-bright")[0][1].getRed());
    assertEquals(255, model.getImage("checker-bright")[0][1].getGreen());
    assertEquals(255, model.getImage("checker-bright")[0][1].getBlue());
    assertEquals(1, model.getImage("checker-bright")[1][0].getRed());
    assertEquals(1, model.getImage("checker-bright")[1][0].getGreen());
    assertEquals(1, model.getImage("checker-bright")[1][0].getBlue());
    assertEquals(255, model.getImage("checker-bright")[1][1].getRed());
    assertEquals(255, model.getImage("checker-bright")[1][1].getGreen());
    assertEquals(255, model.getImage("checker-bright")[1][1].getBlue());
    // the after state for darkening
    ImageFunctionObject darken = new BrightenDarken(-1);
    model.process(darken, "checker", "checker-dark");
    assertEquals(0, model.getImage("checker-dark")[0][0].getRed());
    assertEquals(0, model.getImage("checker-dark")[0][0].getGreen());
    assertEquals(0, model.getImage("checker-dark")[0][0].getBlue());
    assertEquals(254, model.getImage("checker-dark")[0][1].getRed());
    assertEquals(254, model.getImage("checker-dark")[0][1].getGreen());
    assertEquals(254, model.getImage("checker-dark")[0][1].getBlue());
    assertEquals(0, model.getImage("checker-dark")[1][0].getRed());
    assertEquals(0, model.getImage("checker-dark")[1][0].getGreen());
    assertEquals(0, model.getImage("checker-dark")[1][0].getBlue());
    assertEquals(254, model.getImage("checker-dark")[1][1].getRed());
    assertEquals(254, model.getImage("checker-dark")[1][1].getGreen());
    assertEquals(254, model.getImage("checker-dark")[1][1].getBlue());
  }

  @Test
  public void testFlipH() {
    ImageModel model = new ImageModelImpl();
    model.load("1black1white.ppm", "checker");
    ImageFunctionObject flipH = new FlipHorizontal();
    model.process(flipH, "checker", "checkerH");
    assertEquals(255, model.getImage("checkerH")[0][0].getRed());
    assertEquals(255, model.getImage("checkerH")[0][0].getGreen());
    assertEquals(255, model.getImage("checkerH")[0][0].getBlue());
    assertEquals(0, model.getImage("checkerH")[0][1].getRed());
    assertEquals(0, model.getImage("checkerH")[0][1].getGreen());
    assertEquals(0, model.getImage("checkerH")[0][1].getBlue());
  }

  public void testFlipV() {
    ImageModel model = new ImageModelImpl();
    model.load("1black1white.ppm", "checker");
    ImageFunctionObject flipH = new FlipVertical();
  }

  /*
  TestImageWith4Pixels.ppm
  Width of image: 2
  Height of image: 2
  Maximum value of a color in this file (usually 255): 255
  Color of pixel (0,0): 101,90,58
  Color of pixel (1,0): 103,92,62
  Color of pixel (0,1): 110,95,66
  Color of pixel (1,1): 146,118,96
  */

  @Test
  public void testGreyscaleRed() {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject redGrayscale = new Greyscale(ImageModel.RGBVIL.Red);
    model.process(redGrayscale, "checker", "GrayscaleRed");

    assertEquals(101, model.getImage("GrayscaleRed")[0][0].getRed());
    assertEquals(101, model.getImage("GrayscaleRed")[0][0].getGreen());
    assertEquals(101, model.getImage("GrayscaleRed")[0][0].getBlue());
    assertEquals(146, model.getImage("GrayscaleRed")[1][1].getRed());
    assertEquals(146, model.getImage("GrayscaleRed")[1][1].getGreen());
    assertEquals(146, model.getImage("GrayscaleRed")[1][1].getBlue());
  }

  @Test
  public void testGreyscaleGreen() {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject greenGrayscale = new Greyscale(ImageModel.RGBVIL.Green);
    model.process(greenGrayscale, "checker", "GrayscaleGreen");

    assertEquals(90, model.getImage("GrayscaleGreen")[0][0].getRed());
    assertEquals(90, model.getImage("GrayscaleGreen")[0][0].getGreen());
    assertEquals(90, model.getImage("GrayscaleGreen")[0][0].getBlue());
    assertEquals(118, model.getImage("GrayscaleGreen")[1][1].getRed());
    assertEquals(118, model.getImage("GrayscaleGreen")[1][1].getGreen());
    assertEquals(118, model.getImage("GrayscaleGreen")[1][1].getBlue());
  }

  @Test
  public void testGreyscaleBlue() {
    ImageModel model = new ImageModelImpl();
    model.load("TestImageWith4Pixels.ppm", "checker");
    ImageFunctionObject blueGrayscale = new Greyscale(ImageModel.RGBVIL.Blue);
    model.process(blueGrayscale, "checker", "GrayscaleBlue");

    assertEquals(58, model.getImage("GrayscaleBlue")[0][0].getRed());
    assertEquals(58, model.getImage("GrayscaleBlue")[0][0].getGreen());
    assertEquals(58, model.getImage("GrayscaleBlue")[0][0].getBlue());
    assertEquals(96, model.getImage("GrayscaleBlue")[1][1].getRed());
    assertEquals(96, model.getImage("GrayscaleBlue")[1][1].getGreen());
    assertEquals(96, model.getImage("GrayscaleBlue")[1][1].getBlue());
  }

}
