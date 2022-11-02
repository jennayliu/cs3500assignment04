import org.junit.Test;

import java.io.StringReader;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.ImageModel;
import model.ImageModelImpl;
import model.command.BrightenDarken;
import model.command.FlipHorizontal;
import model.command.FlipVertical;
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
      for (int c = 0; c < model.getImage("black").length; c ++) {
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


}
