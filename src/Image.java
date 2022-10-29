/**
 * This class represents an image represented by an array of an array of pixels.
 */
public class Image {
  private final Pixel[][] pixels;

  /**
   * The constructor which takes in a filename.
   * @param filename The name of the image file.
   */
  public Image(String filename) {
    pixels = null; // pixels = ImageUtil.readPPM(filename); see notes below
  }

}

/**
 * Notes/Ideas:
 * I want to make readPPM return an array of and array of pixels instead of just printing out
 * everything.
 * We can then use this modified readPPM method to initialize the pixels field of the Image class.
 * This gives us an accurate representation of the image's pixel's RGB as well as their coordinates.
 *
 * The pixel class will have red green blue integer fields to represent a pixel.
 *
 * As for the model, in order to make it more flexible, Vidoje recommended that we make the model
 * take in function objects that do the assignment requirements (flip, brighten, greyscale) instead
 * of just writing a bunch of methods in the interface in order to make the design more extendable
 * to future assignments.
 *
 * Load
 * Save (should loading and saving be part of the model?) | Should do this one first
 *
 * Function objects needed:
 * VisualizeRed
 * VisualizeGreen
 * VisualizeBlue (might be able to combine VisualizeRGB and add a color enum field)
 * VisualizeValue
 * VisualizeIntensity
 * VisualizeLuma (might be able to combine VisualizeVIL and add a vil enum field)
 * FlipHorizontally
 * FlipVertically
 * Brighten (will also probably need a field to determine HOW much to brighten)
 * Darken (will also probably need a field to determine HOW much to darken)
 *
 *
 * "The model will be a storage for your images"
 * "Our view for now is run"
 *
 * Test a picture of 4x4 or 3x3 pixels and check every pixel using a for loop
 */