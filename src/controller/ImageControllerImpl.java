package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.command.BrightenDarken;
import model.command.ImageFunctionObject;
import model.ImageModel;
import model.PixelRGB;

/**
 * This class is the implementation of the ImageController.
 */
public class ImageControllerImpl implements ImageController {

  private final ImageModel model;
  private final Readable readable;
  private final Appendable appendable;

  /**
   * This constructor creates an instance of a controller.
   * @param model The model to work with
   * @param readable The readable to read from
   * @param appendable The appendable to transmit outputs
   * @throws IllegalArgumentException If any of the fields are null
   */
  public ImageControllerImpl(ImageModel model, Readable readable, Appendable appendable)
  throws IllegalArgumentException {
    if (model == null || readable == null || appendable == null) {
      throw new IllegalArgumentException("Can't have null fields.");
    }

    this.model = model;
    this.readable = readable;
    this.appendable = appendable;
  }

  @Override
  public void control() throws IOException {
    Scanner sc = new Scanner(this.readable);
    boolean quit = false;
    while (!quit){
      if (sc.hasNextLine()) {

        String command = sc.nextLine();

        // split command into some tokens, on space we split
        String[] commandArray = command.split(" ");


        switch (commandArray[0]) {
          case ("load"):
            String imageFormat = commandArray[1].split("\\.")[1];
            if (imageFormat.equals("ppm")) {
              model.load(commandArray[1], commandArray[2]);
            } // implement methods in later case, if it's not a ppm file
            break;
          case ("save"):
            break;

          case ("red-component"):

          case ("green-component"):

          case ("blue-component"):

          case ("horizontal-flip"):

          case ("vertical-flip"):

          case ("brighten"):
            ImageFunctionObject brighten = new BrightenDarken(Integer.parseInt(commandArray[1]),
                    true);
            model.process(brighten, commandArray[2], commandArray[3]);

          default:
            this.appendable.append("Unknown command.");
        }
      } else {
        throw new IllegalArgumentException("Invalid: No input.");
      }
    }


  }

  private void save(PixelRGB[][] image, String filename) throws IOException {
    File newImage = new File(filename);
    FileWriter filewriter = new FileWriter(newImage);
    filewriter.write("P3" + System.lineSeparator());
    for (int r = 0; r < image[0].length; r++) {
      for (int c = 0; c < image.length; c ++) {
        filewriter.write(image[r][c].getRed() + System.lineSeparator());
        filewriter.write(image[r][c].getGreen() + System.lineSeparator());
        filewriter.write(image[r][c].getBlue() + System.lineSeparator());
      }
    }
    filewriter.close();

  }

}
