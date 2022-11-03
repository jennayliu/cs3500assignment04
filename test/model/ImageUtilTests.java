package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageUtilTests {

  @Test
  public void testReadPPM() {
    PixelRGB[][] image = ImageUtil.readPPM("1black1white.ppm");
    assertEquals(0, image[0][0].getRed());
    assertEquals(0, image[0][0].getGreen());
    assertEquals(0, image[0][0].getBlue());
    assertEquals(255, image[0][0].getMax());
    assertEquals(255, image[0][1].getRed());
    assertEquals(255, image[0][1].getGreen());
    assertEquals(255, image[0][1].getBlue());
    assertEquals(255, image[0][1].getMax());
  }
}
