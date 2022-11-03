package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static PixelRGB[][] readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found!");
      // changed to return an empty pixel array
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    // new
    PixelRGB[][] pixels = new PixelRGB[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Color of pixel (" + j + "," + i + "): " + r + "," + g + "," + b);

        // new
        pixels[i][j] = new PixelRGB(r, g, b, maxValue);
      }
    }

    // new
    return pixels;
  }

  /**
   * Write a image from PixelRGB[][] format to PPM format.
   *
   * @param image    the image to convert to PPM format
   * @param filename the file name of the PPM format file
   * @throws IOException if image cannot be converted to ppm
   */
  public static void writePPM(PixelRGB[][] image, String filename) throws IOException {
    File newImage = new File(filename);
    FileWriter filewriter = new FileWriter(newImage);

    filewriter.write("P3" + System.lineSeparator());
    filewriter.write(image[0].length + " " + image.length + System.lineSeparator());
    filewriter.write(image[0][0].getMax() + System.lineSeparator());

    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
        filewriter.write(image[r][c].getRed() + System.lineSeparator());
        filewriter.write(image[r][c].getGreen() + System.lineSeparator());
        filewriter.write(image[r][c].getBlue() + System.lineSeparator());
      }
    }
    filewriter.close();
  }

  //demo main
  public static void main(String[] args) {
    String filename;

    if (args.length > 0) {
      filename = args[0];
    } else {
      filename = "sample.ppm";
    }

    ImageUtil.readPPM(filename);
  }
}

