import java.io.InputStreamReader;

import Controller.ImageController;
import Controller.ImageControllerImpl;
import Model.ImageModel;
import Model.ImageModelImpl;

/**
 * The main class.
 */
public class Main {
  /**
   * The main method.
   * @param args input from the user
   */
  public static void main(String[] args) {
    ImageModel model = new ImageModelImpl();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    ImageController controller = new ImageControllerImpl(model, rd, ap);
    // controller.control();
  }
}
