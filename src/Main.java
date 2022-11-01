import java.io.IOException;
import java.io.InputStreamReader;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.ImageRepo;
import model.ImageRepoImpl;

/**
 * The main class.
 */
public class Main {
  /**
   * The main method.
   * @param args input from the user
   */
  public static void main(String[] args) throws IOException {
    ImageRepo model = new ImageRepoImpl();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    ImageController controller = new ImageControllerImpl(model, rd, ap);
    controller.control();
  }
}
