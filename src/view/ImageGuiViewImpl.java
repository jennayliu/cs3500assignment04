package view;

import java.awt.*;

import javax.swing.*;

public class ImageGuiViewImpl implements ImageGuiView{

  private final int width;
  private final int height;

  private final JFrame baseFrame;


  public ImageGuiViewImpl() {

    this.width = 1920;
    this.height = 1080;
    this.baseFrame = new JFrame("Image Processor");
  }

  @Override
  public void initialize() {
    this.baseFrame.setSize(1920,1080);

    JPanel mainPanel = new JPanel();
    this.initializePanel(mainPanel);

    baseFrame.add(mainPanel);

    this.baseFrame.setVisible(true);
  }

  private void initializePanel(JPanel mainPanel){
    mainPanel.setSize(1920,1080);

    mainPanel.setLayout(new BorderLayout());
    JPanel leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(this.width / 7, this.height));

    JPanel rightPanel = new JPanel();


    this.initialCommandPanel(leftPanel);

    JPanel centerPanel = new JPanel();

    mainPanel.add(leftPanel, BorderLayout.WEST);
    mainPanel.add(rightPanel, BorderLayout.EAST);
    mainPanel.add(centerPanel);
  }

  private void initialCommandPanel(JPanel leftPanel){
    //for elements to be arranged vertically within this panel
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
//    //scroll bars around this main panel
//    JScrollPane rightScrollPane = new JScrollPane(rightPanel);
//    rightPanel.add(rightScrollPane);

    JPanel greyScalePanel = new JPanel();
    greyScalePanel.setBorder(BorderFactory.createTitledBorder("GreyScale"));
    greyScalePanel.setLayout(new BoxLayout(greyScalePanel, BoxLayout.PAGE_AXIS));
    leftPanel.add(greyScalePanel);

    String[] options = {"Like it", "Love it", "Gotta have it"};
    JComboBox<String> combobox = new JComboBox<String>();
    //the event listener when an option is selected
    combobox.setActionCommand("Size options");
    for (int i = 0; i < options.length; i++) {
      combobox.addItem(options[i]);
    }
    greyScalePanel.add(combobox);

  }

}

