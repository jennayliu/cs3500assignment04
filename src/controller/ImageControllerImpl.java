package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.command.BrightenDarken;
import model.command.FlipHorizontal;
import model.command.FlipVertical;
import model.command.Greyscale;
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
   *
   * @param model      The model to work with
   * @param readable   The readable to read from
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
    this.appendable = appendable; //save for view in the future
  }

  @Override
  public void control() throws IOException {
    Scanner sc = new Scanner(this.readable);

    while (sc.hasNextLine()) {

      String command = sc.nextLine();

      // split command into some tokens, split by space
      String[] commandArray = command.split(" ");


      switch (commandArray[0]) {
        case ("load"):
          String imageFormat = commandArray[1].split("\\.")[1];

          // if (imageFormat.equals("ppm")) {
          model.load(commandArray[1], commandArray[2]);
          // } implement methods in later case, if it's not a ppm file
          this.appendable.append("Successfully load the image.");
          break;

        case ("save"):
          model.save(commandArray[1], commandArray[2]);
          this.appendable.append("Successfully save the image.");
          break;

        case ("red-component"):
          ImageFunctionObject redGreyscale = new Greyscale(ImageModel.RGBVIL.Red);
          model.process(redGreyscale, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully grayscale the image by red.");
          break;

        case ("green-component"):
          ImageFunctionObject greenGreyscale = new Greyscale(ImageModel.RGBVIL.Green);
          model.process(greenGreyscale, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully grayscale the image by green.");
          break;

        case ("blue-component"):
          ImageFunctionObject blueGreyscale = new Greyscale(ImageModel.RGBVIL.Blue);
          model.process(blueGreyscale, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully grayscale the image by blue.");
          break;

        case ("value-component"):
          ImageFunctionObject valueGreyscale = new Greyscale(ImageModel.RGBVIL.Value);
          model.process(valueGreyscale, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully grayscale the image by value.");
          break;

        case ("luma-component"):
          ImageFunctionObject lumaGreyscale = new Greyscale(ImageModel.RGBVIL.Luma);
          model.process(lumaGreyscale, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully grayscale the image by luma.");
          break;

        case ("intensity-component"):
          ImageFunctionObject intensityGreyscale = new Greyscale(ImageModel.RGBVIL.Value);
          model.process(intensityGreyscale, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully grayscale the image by intensity.");
          break;

        case ("horizontal-flip"):
          ImageFunctionObject horizontalFlip = new FlipHorizontal();
          model.process(horizontalFlip, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully flip horizontally the image.");
          break;

        case ("vertical-flip"):
          ImageFunctionObject verticalFlip = new FlipVertical();
          model.process(verticalFlip, commandArray[1], commandArray[2]);
          this.appendable.append("Successfully flip vertically the image.");
          break;

        case ("brighten"):
          ImageFunctionObject brighten = new BrightenDarken(Integer.parseInt(commandArray[1]));
          model.process(brighten, commandArray[2], commandArray[3]);
          this.appendable.append("Successfully brighten the image.");
          break;

        default:
          this.appendable.append("Unknown command.");
      }
    }
  }



}
