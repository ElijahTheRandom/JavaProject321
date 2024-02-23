package tagifyme.model;

/**
 * Base class for a "tag" within the database.
 * @author ethan
 */
public class Tag {
  private String name;

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
}
