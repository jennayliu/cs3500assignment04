import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.ImageController;
import controller.ImageControllerImpl;
import controller.ImageGuiController;
import controller.ImageGuiControllerImpl;
import model.ImageModel;
import model.ImageModelImpl;
import view.ImageGuiView;
import view.ImageGuiViewImpl;

/**
 * The main class.
 */
public class Main {
  /**
   * The main method.
   * @param args input from the user
   */
  public static void main(String[] args) throws IOException {

    ImageGuiView view;
    ImageModel model = new ImageModelImpl();
    ImageController controller;
    ImageGuiController guiController;
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;



    // I don't know if this if statement is needed, can remove and adjust after
    if (args[0].equals("-jar") && args[1].equals("Program.jar")) {

      switch (args.length) {
        case (2):
          // equivalent to opening a jar file
          view = new ImageGuiViewImpl();
          // Start the guiController, initialize the main frame in side the constructor
          guiController = new ImageGuiControllerImpl(model, view);


          break;
        case (3):
          if (args[2].equals("-text")) {
            // interactive text mode
            model = new ImageModelImpl();
            controller = new ImageControllerImpl(model, rd, ap);
            controller.control();
          } else {
            // bad quit
          }
          break;
        case (5):
          if (args[3].equals("-file")) {
            // execute the file named args[4]
          } else {
            // bad quit
          }
          break;
        default:
          // bad quit
      }

    }

    controller = new ImageControllerImpl(model, rd, ap);
    controller.control();

  }
}
