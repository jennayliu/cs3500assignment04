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
    // setting up view for guiController
    ImageGuiView view = new ImageGuiViewImpl();
    ImageModel model = new ImageModelImpl();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;

    ImageController controller = new ImageControllerImpl(model, rd, ap);
    // Start the guiController, initialize the main frame in side the constructor
    ImageGuiController guiController = new ImageGuiControllerImpl(model, view);

    controller.control();

  }
}
