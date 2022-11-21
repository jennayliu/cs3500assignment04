import java.io.IOException;
import java.io.InputStreamReader;

import controller.ImageController;
import controller.ImageControllerImpl;
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
    ImageGuiView view = new ImageGuiViewImpl();
    view.initialize();

    ImageModel model = new ImageModelImpl();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    ImageController controller = new ImageControllerImpl(model, rd, ap);
    controller.control();

  }
}
