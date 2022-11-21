package view;

import java.awt.*;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import controller.ImageGuiController;
import controller.ImageGuiControllerImpl;

public class ImageGuiViewImpl implements ImageGuiView {

  private final int width;
  private final int height;

  private final JFrame baseFrame;
  private ImageGuiController controller;

  private final java.util.List<ViewEvents> listeners;

  public ImageGuiViewImpl() {
    this.listeners  = new ArrayList<>();
    this.width = 1920;
    this.height = 1080;
    this.baseFrame = new JFrame("Image Processor");
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
    JPanel leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(this.width / 7, this.height));

    JPanel rightPanel = new JPanel();


    this.initialLeftPanel(leftPanel);

    JPanel centerPanel = new JPanel();

    mainPanel.add(leftPanel, BorderLayout.WEST);
    mainPanel.add(rightPanel, BorderLayout.EAST);
    mainPanel.add(centerPanel);
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
    loadSavePanel.setLayout(new GridLayout(1,2));
    leftPanel.add(loadSavePanel);

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
        for ( ViewEvents listener : listeners ) {
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
    JButton saveButton = new JButton("Save");
    loadSavePanel.add(loadButton);
    loadSavePanel.add(saveButton);

    // This part is for brighten & darken
    JPanel brightenPanel = new JPanel();
    brightenPanel.setBorder(BorderFactory.createTitledBorder("Brighten & Darken"));
    brightenPanel.setLayout(new GridLayout(2,1));
    leftPanel.add(brightenPanel);

    JSlider brightenSlider = new JSlider(-255, 255,0);
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

    // This part is for flip
    JPanel sepiaPenal = new JPanel();
    sepiaPenal.setBorder(BorderFactory.createTitledBorder("Sepia"));
    sepiaPenal.setLayout(new GridLayout(1, 1));
    leftPanel.add(sepiaPenal);

    JButton sepiaButton = new JButton("Sepia");
    //OKButton.addActionListener(new MyAction());
    sepiaPenal.add(sepiaButton);


  }

  public void setController (ImageGuiController controller){
    this.controller = controller;
  }

}

