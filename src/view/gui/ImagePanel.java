package view.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.ControllerInterface;
import controller.ImageController;
import model.Layer;


/**
 * Class representing a panel which holds an image in a scroll pane.
 */
public class ImagePanel extends JPanel {
  private BufferedImage img;
  private ControllerInterface ic;
  private ListModel layerList;

  /**
   * Constructor for the ImagePanel class.
   */
  public ImagePanel(ImageController ic) {
    super();
    this.setBorder(new TitledBorder("Current Image"));
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.img = img;
    JLabel imageLabel = new JLabel();
    setPreferredSize(new Dimension(ic.getProject().getWidth(), ic.getProject().getHeight()));
    this.ic = ic;
  }

  /**
   * Method  BufferedImag, represent BufferedImag for image.
   * @return image
   */
  public BufferedImage getImage() {
    return this.img;
  }

  /**
   * Method paintComponent, allows the original image to be altered.
   *
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Layer layer = this.ic.getProject().combineAllLayers();
    this.img = JFrameView.ppmImageToBufferedImage(layer);

    g.drawImage(this.img, 0, 0,  getWidth(), getHeight(), this); /// draw image
    this.repaint();
  }
}
