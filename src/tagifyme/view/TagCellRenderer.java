/**
 * A Cell Renderer for Tags.
 */
package tagifyme.view;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import tagifyme.model.Tag;

public class TagCellRenderer extends DefaultListCellRenderer {
  public TagCellRenderer() {
    super();
  }

  @Override
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    JLabel label = (JLabel) super.getListCellRendererComponent(
      list, value, index, isSelected, cellHasFocus);
    // TODO: We're reconstructing the Tag here... I'm assuming
    // the JList takes a String?
    label.setIcon(new TagIcon(new Tag((String) value)));
    label.setHorizontalTextPosition(JLabel.RIGHT);

    // TODO: Turn into constants.
    label.setBorder(new EmptyBorder(5, 5, 5, 5));

    return label;
  }
}
