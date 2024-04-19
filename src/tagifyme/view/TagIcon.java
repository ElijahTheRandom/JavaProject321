/** A GFX object for a Tag.
 */
package tagifyme.view;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import tagifyme.model.Tag;

/**
 * The `TagIcon` is an extension of `ImageIcon`.
 */
public class TagIcon extends ImageIcon {

  private Tag t;
  private static final Color cList[] = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.ORANGE};

  /**
   * Create a `TagIcon` from the specified `Tag`.
   */
  public TagIcon(Tag t) {
    super();
    this.t = t;
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    super.paintIcon(c, g, x, y);
    Graphics2D g2d = (Graphics2D) g.create();
    computeImage(t, g2d);
  }
  
  @Override
  public int getIconWidth() {
    return 15;
  }

  @Override
  public int getIconHeight() {
    return 15;
  }

  /**
   * Compute an image from a passed `Tag` and the Graphics object.
   */
  private void computeImage(Tag t, Graphics2D g2d) {
    int h = t.hashCode();

    // Compute four colors.
    Color c1 = cList[java.lang.Math.abs((h >> 0)) % cList.length];
    Color c2 = cList[java.lang.Math.abs((h >> 1)) % cList.length];
    Color c3 = cList[java.lang.Math.abs((h >> 2)) % cList.length];
    Color c4 = cList[java.lang.Math.abs((h >> 3)) % cList.length];

    int width  = getIconWidth();
    int height = getIconHeight();

    // Split the square into four equal bits; write
    // a color to each of those four portions.

    g2d.setColor(c1);
    g2d.fillRect(0, 0, width/2, height/2);
    g2d.setColor(c2);
    g2d.fillRect(width/2, 0, width, height/2);
    g2d.setColor(c3);
    g2d.fillRect(0, height/2, width/2, height);
    g2d.setColor(c4);
    g2d.fillRect(width/2, height/2, width, height);

    g2d.dispose();
  }
}
