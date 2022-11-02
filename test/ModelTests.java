import org.junit.Test;

import java.io.StringReader;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.ImageModel;
import model.ImageModelImpl;

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


}
