/* Within the database the 'Tag' is some sort of affinity
 * to associate with data.
 */
package tagifyme.model;
import java.io.Serializable;

/**
 * A `Tag` is some affinity attached to Data.
 */
public class Tag implements Comparable<Tag>, Serializable {
  private final String name;

  /**
   * Construct a tag with a specific name.
   * @param name the identifier for the tag.
   */
  public Tag(String name) {
    this.name = name;
  }

  /**
   * Return the name of the Tag.
   * @return returns name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Compare this tag to another via the Comparable interface.
   * @param other the other tag to compare to.
   */
  @Override
  public int compareTo(Tag other) {
    return this.getName().compareTo(other.getName());
  }

  // NOTE: Both of these Overrides are needed to have the Set functionality we
  // require; a Tag should be differentiated based upon its string indentifier,
  // not its object. See the above compareTo.
  
  /**
   * Return the hashCode for this object.
   */
  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }

  /**
   * An `.equals()` overload for comparing tags.
   * @param obj other object to compare to.
   * @return boolean of tag equivalency  
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    final Tag other = (Tag) obj;
    return this.getName().equals(other.getName());
  }
}
