package view;

import controller.ImageGuiControllerImpl;
import model.PixelRGB;

public interface ImageGuiView {

  /**
   * Use to Initialize the gui frame.
   */
  public void initialize();


  /**
   * Set the controller of the image gui.
   * @param
   */
  public void addViewListener(ViewEvents listener);

  public void showCenterImage(String imageName, PixelRGB[][] image);
}