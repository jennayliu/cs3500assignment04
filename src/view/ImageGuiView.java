package view;

import controller.ImageGuiControllerImpl;

public interface ImageGuiView {

  /**
   * Use to Initialize the gui frame.
   */
  public void initialize();


  /**
   * Set the controller of the image gui.
   * @param
   */
  void addViewListener(ViewEvents listener);
}