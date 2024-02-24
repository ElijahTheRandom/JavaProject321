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

  public String getName() {
    return this.name;
  }

  /**
   * Compare this tag to another via the Comparable interface.
   */
  @Override
  public int compareTo(Tag other) {
    return this.getName().compareTo(other.getName());
  }
}
