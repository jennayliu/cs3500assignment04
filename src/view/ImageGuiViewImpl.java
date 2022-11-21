package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import controller.ImageGuiController;
import controller.ImageGuiControllerImpl;
import model.ImageModel;
import model.Pixel;
import model.PixelRGB;

public class ImageGuiViewImpl implements ImageGuiView {

  private final int width;
  private final int height;
  private final JFrame baseFrame;

  private final JPanel rightPanel;
  private final JPanel leftPanel;
  private final JPanel centerPanel;

  private final java.util.List<ViewEvents> listeners;

  public ImageGuiViewImpl() {
    this.listeners = new ArrayList<>();
    this.width = 1920;
    this.height = 1080;
    this.baseFrame = new JFrame("Image Processor");

    this.centerPanel = new JPanel();
    this.leftPanel = new JPanel();
    this.rightPanel = new JPanel();
  }

  @Override
  public void initialize() {
    this.baseFrame.setSize(1920, 1080);

    JPanel mainPanel = new JPanel();
    this.initializePanel(mainPanel);

    baseFrame.add(mainPanel);

    this.baseFrame.setVisible(true);
  }

  @Override
  public void addViewListener(ViewEvents listener) {
    this.listeners.add(Objects.requireNonNull(listener));
  }

  private void initializePanel(JPanel mainPanel) {
    mainPanel.setSize(1920, 1080);

    mainPanel.setLayout(new BorderLayout());

    this.leftPanel.setPreferredSize(new Dimension(this.width / 7, this.height));
    this.initialLeftPanel(this.leftPanel);


    this.rightPanel.setPreferredSize(new Dimension(this.width / 7, this.height));
    this.initialRightPanel(this.rightPanel);


    this.centerPanel.setPreferredSize(new Dimension(this.width * 5 / 7, this.height * 3 / 2));
    this.initialCenterPanel(this.centerPanel);

    mainPanel.add(leftPanel, BorderLayout.WEST);
    mainPanel.add(rightPanel, BorderLayout.EAST);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
  }

  /**
   * This method creates the picture reveal panel(on the center), which is use to show the picture.
   *
   * @param centerPanel the center panel for placing the picture to modify
   */
  private void initialCenterPanel(JPanel centerPanel) {
    centerPanel.setBackground(Color.LIGHT_GRAY);
    centerPanel.setBorder(BorderFactory.createTitledBorder("Click \"Load\" Button to load"));

  }

  /**
   * This method creates the histogram panel(on the right), which is use to show the histogram.
   *
   * @param rightPanel the right panel for placing the picture to modify
   */
  private void initialRightPanel(JPanel rightPanel) {
    rightPanel.setBorder(BorderFactory.createTitledBorder("Histogram"));

  }

  /**
   * This method creates the command Panel(on the left), which is use to modify the picture.
   *
   * @param leftPanel the left panel for placing these panels
   */
  private void initialLeftPanel(JPanel leftPanel) {
    //for elements to be arranged vertically within this panel
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
//    //scroll bars around this main panel
//    JScrollPane rightScrollPane = new JScrollPane(rightPanel);
//    rightPanel.add(rightScrollPane);

    // This part is for Load & Save
    JPanel loadSavePanel = new JPanel();
    loadSavePanel.setBorder(BorderFactory.createTitledBorder("Load & Save"));
    loadSavePanel.setLayout(new GridLayout(1, 2));
    leftPanel.add(loadSavePanel);

    // This Button is for Load
    JButton loadButton = new JButton("Load");
    loadButton.addActionListener(e -> {
      JFileChooser fc = new JFileChooser();
      fc.setDialogTitle("Choose image to modify");
      fc.showOpenDialog(null); // what this means??
      //get the selected file
      File image = fc.getSelectedFile();

      if (image != null) {
        String imagePath = image.getAbsolutePath();
        String imageName = image.getName();
        for (ViewEvents listener : listeners) {
          try {
            listener.loadEvent(imageName, imagePath);
          } catch (NoSuchFileException ex) {
            throw new RuntimeException("Image not found.");
          }
        }
      } else {
        throw new IllegalArgumentException("Invalid image");
      }

    });

    // This Button is for Save
    JButton saveButton = new JButton("Save");
    loadSavePanel.add(loadButton);
    loadSavePanel.add(saveButton);

    // This part is for brighten & darken
    JPanel brightenPanel = new JPanel();
    brightenPanel.setBorder(BorderFactory.createTitledBorder("Brighten & Darken"));
    brightenPanel.setLayout(new GridLayout(2, 1));
    leftPanel.add(brightenPanel);

    JSlider brightenSlider = new JSlider(-255, 255, 0);
    brightenSlider.setPaintTicks(true);
    brightenSlider.setMajorTickSpacing(51);
    brightenSlider.setMinorTickSpacing(10);
    brightenSlider.setPaintLabels(true);
    brightenPanel.add(brightenSlider);

    JButton brightenButton = new JButton("Brighten");
    brightenPanel.add(brightenButton);

    // This part is for GreyScale
    JPanel greyScalePanel = new JPanel();
    greyScalePanel.setBorder(BorderFactory.createTitledBorder("GreyScale"));
    greyScalePanel.setLayout(new GridLayout(2, 1));
    leftPanel.add(greyScalePanel);

    String[] options = {"N/A", "Red Component", "Green Component", "Blue Component",
            "Value Component", "Intensity Component", "Luma Component", "Greyscale"};
    JComboBox<String> combobox = new JComboBox<String>();
    combobox.setActionCommand("Greyscale options");
    for (int i = 0; i < options.length; i++) {
      combobox.addItem(options[i]);
    }
    greyScalePanel.add(combobox);

    JButton greyScaleButton = new JButton("Greyscale");
    //OKButton.addActionListener(new MyAction());
    greyScalePanel.add(greyScaleButton);

    // This part is for flip
    JPanel flipPanel = new JPanel();
    flipPanel.setBorder(BorderFactory.createTitledBorder("Flip"));
    flipPanel.setLayout(new GridLayout(2, 1));
    leftPanel.add(flipPanel);

    JButton verFlipButton = new JButton("Vertical Flip");

    JButton hoFlipButton = new JButton("Horizontal Flip");

    //OKButton.addActionListener(new MyAction());
    flipPanel.add(verFlipButton);
    flipPanel.add(hoFlipButton);

    // This part is for Sepia
    JPanel sepiaPenal = new JPanel();
    sepiaPenal.setBorder(BorderFactory.createTitledBorder("Sepia"));
    sepiaPenal.setLayout(new GridLayout(1, 1));
    leftPanel.add(sepiaPenal);
    // create Button for sepia
    JButton sepiaButton = new JButton("Sepia");
//    sepiaButton.addActionListener(e -> {
//      for (ViewEvents listener : listeners) {
//          listener.SepiaEvent(imageName);
//        }
//      }
//    };
//    sepiaPenal.add(sepiaButton);

  }

  @Override
  public void showCenterImage(String imageName, PixelRGB[][] image){
    centerPanel.setBorder(BorderFactory.createTitledBorder("Image: " + imageName));
    try {
      BufferedImage showingImage = new BufferedImage(image[0].length, image.length,
              BufferedImage.TYPE_INT_RGB);
      for (int r = 0; r < image.length; r++) {
        for (int c = 0; c < image[0].length; c++) {
          Pixel pixel = image[r][c];
          Color color = new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue());
          showingImage.setRGB(c, r, color.getRGB());
        }
      }

      Icon icon=new ImageIcon(showingImage);
      JLabel imageLabel = new JLabel(icon, JLabel.CENTER);
      this.centerPanel.add(imageLabel);
      this.baseFrame.repaint();
      this.baseFrame.revalidate();
    } catch (IllegalArgumentException e) {

    }
      return;
  }


}

