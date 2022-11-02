package view;

import java.io.IOException;

/**
 * An Implementation for view interface
 */
public class ImageViewImpl implements ImageView {
  private final Appendable appendable;


  /**
   * Constructor for ViewImageImpl;
   *
   * @param appendable the appendable object that pass to view
   */
  public ImageViewImpl(Appendable appendable) throws IllegalArgumentException {
    if (appendable == null){
      throw new IllegalArgumentException("Invalid, object to render cannot be null.");
    } else{
      this.appendable = appendable;
    }

  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}

