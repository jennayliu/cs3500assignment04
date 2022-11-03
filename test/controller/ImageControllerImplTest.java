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

  @Test
  public void testFlipH() throws IOException {
    ImageModel model = new ImageModelImpl();
    Readable input = new StringReader("load 1black1white.ppm checker " + System.lineSeparator()
            + "horizontal-flip checker checkerH");
    Appendable output = new StringBuilder("");
    ImageController controller = new ImageControllerImpl(model, input, output);
    controller.control();
    assertEquals(255, model.getImage("checkerH")[0][0].getRed());
    assertEquals(255, model.getImage("checkerH")[0][0].getGreen());
    assertEquals(255, model.getImage("checkerH")[0][0].getBlue());
    assertEquals(255, model.getImage("checkerH")[0][0].getMax());

    assertEquals(0, model.getImage("checkerH")[0][1].getRed());
    assertEquals(0, model.getImage("checkerH")[0][1].getGreen());
    assertEquals(0, model.getImage("checkerH")[0][1].getBlue());
    assertEquals(255, model.getImage("checkerH")[0][1].getMax());

    assertEquals("Successfully load the image.Successfully flip horizontally the image.",
            output.toString());
  }

  @Test
  public void testFlipV() throws IOException {
    ImageModel model = new ImageModelImpl();
    Readable input = new StringReader("load 1black1whiteVertical.ppm checker " + System.lineSeparator()
            + "vertical-flip checker checkerV");
    Appendable output = new StringBuilder("");
    ImageController controller = new ImageControllerImpl(model, input, output);
    controller.control();
    assertEquals(255, model.getImage("checkerV")[0][0].getRed());
    assertEquals(255, model.getImage("checkerV")[0][0].getGreen());
    assertEquals(255, model.getImage("checkerV")[0][0].getBlue());
    assertEquals(255, model.getImage("checkerV")[0][0].getMax());

    assertEquals(0, model.getImage("checkerV")[1][0].getRed());
    assertEquals(0, model.getImage("checkerV")[1][0].getGreen());
    assertEquals(0, model.getImage("checkerV")[1][0].getBlue());
    assertEquals(255, model.getImage("checkerV")[1][0].getMax());
    assertEquals("Successfully load the image.Successfully flip vertically the image.",
            output.toString());
  }

  @Test
  public void testBrighten() throws IOException {
    ImageModel model = new ImageModelImpl();
    Readable input = new StringReader("load 1black1whiteVertical.ppm checker " + System.lineSeparator()
            + "brighten 10 checker checkerB");
    Appendable output = new StringBuilder("");
    ImageController controller = new ImageControllerImpl(model, input, output);
    controller.control();
    assertEquals(10, model.getImage("checkerB")[0][0].getRed());
    assertEquals(10, model.getImage("checkerB")[0][0].getGreen());
    assertEquals(10, model.getImage("checkerB")[0][0].getBlue());
    assertEquals(255, model.getImage("checkerB")[0][0].getMax());

    assertEquals(255, model.getImage("checkerB")[1][0].getRed());
    assertEquals(255, model.getImage("checkerB")[1][0].getGreen());
    assertEquals(255, model.getImage("checkerB")[1][0].getBlue());
    assertEquals(255, model.getImage("checkerB")[1][0].getMax());
    assertEquals("Successfully load the image.Successfully brighten the image.",
            output.toString());
  }

  @Test
  public void testDarken() throws IOException {
    ImageModel model = new ImageModelImpl();
    Readable input = new StringReader("load 1black1whiteVertical.ppm checker " + System.lineSeparator()
            + "brighten -10 checker checkerB");
    Appendable output = new StringBuilder("");
    ImageController controller = new ImageControllerImpl(model, input, output);
    controller.control();
    assertEquals(0, model.getImage("checkerB")[0][0].getRed());
    assertEquals(0, model.getImage("checkerB")[0][0].getGreen());
    assertEquals(0, model.getImage("checkerB")[0][0].getBlue());
    assertEquals(255, model.getImage("checkerB")[0][0].getMax());

    assertEquals(245, model.getImage("checkerB")[1][0].getRed());
    assertEquals(245, model.getImage("checkerB")[1][0].getGreen());
    assertEquals(245, model.getImage("checkerB")[1][0].getBlue());
    assertEquals(255, model.getImage("checkerB")[1][0].getMax());
    assertEquals("Successfully load the image.Successfully brighten the image.",
            output.toString());
  }


}