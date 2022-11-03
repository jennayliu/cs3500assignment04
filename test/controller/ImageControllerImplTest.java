package controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import model.ImageModel;
import model.ImageModelImpl;

import static org.junit.Assert.assertEquals;


/**
 * Test class for testing image controller.
 */
public class ImageControllerImplTest {

  // test for controller load
  @Test
  public void testControllerLoad() throws IOException {
    ImageModel model = new ImageModelImpl();
    Readable input = new StringReader("load 1black1whiteVertical.ppm checker");
    Appendable output = new StringBuilder("");
    ImageController controller = new ImageControllerImpl(model, input, output);
    controller.control();

    assertEquals(0, model.getImage("checker")[0][0].getRed());
    assertEquals(0, model.getImage("checker")[0][0].getGreen());
    assertEquals(0, model.getImage("checker")[0][0].getBlue());
    assertEquals(255, model.getImage("checker")[0][0].getMax());

    assertEquals(255, model.getImage("checker")[1][0].getRed());
    assertEquals(255, model.getImage("checker")[1][0].getGreen());
    assertEquals(255, model.getImage("checker")[1][0].getBlue());
    assertEquals(255, model.getImage("checker")[1][0].getMax());
  }

  @Test
  public void testControllerSave() throws IOException {
    ImageModel model = new ImageModelImpl();
    Readable input = new StringReader("load 1black1whiteVertical.ppm checker");
    Appendable output = new StringBuilder("");
    ImageController controller = new ImageControllerImpl(model, input, output);
    controller.control();

    assertEquals(0, model.getImage("checker")[0][0].getRed());
    assertEquals(0, model.getImage("checker")[0][0].getGreen());
    assertEquals(0, model.getImage("checker")[0][0].getBlue());
    assertEquals(255, model.getImage("checker")[0][0].getMax());

    assertEquals(255, model.getImage("checker")[1][0].getRed());
    assertEquals(255, model.getImage("checker")[1][0].getGreen());
    assertEquals(255, model.getImage("checker")[1][0].getBlue());
    assertEquals(255, model.getImage("checker")[1][0].getMax());
  }
}