package controller;

import java.io.IOException;

public interface ImageGuiController {

  /**
   * The main method will call this method, which allows the ImageGuiController to take control of
   * the program.
   * @throws IOException If any transmission fails
   */
  public void control() throws IOException;
}