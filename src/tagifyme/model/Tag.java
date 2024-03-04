package tagifyme.model;

/**
 * Base class for a "tag" within the database.
 * @author ethan
 */
public class Tag implements Comparable<Tag> {
  private final String name;

/**
 * Construct a tag with a specific name.
 * @param name 
 */
  public Tag(String name) {
    this.name = name;
  }
/**
 * 
 * @return Returns name
 */
  public String getName() {
    return this.name;
  }

  /**
   * Compare this tag to another via the Comparable interface.
     * @param other
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
 * .equals() overload for comparing tags
 * @param obj
 * @return Boolean of tag equivalency  
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
