package view;

import java.io.IOException;

/**
 *
 */
public interface ImageView {


  /**
   * Render a given message.
   *
   * @param message message to pass to user through view
   * @throws IOException if message not input or output correctly.
   */
  void renderMessage(String message) throws IOException;

}