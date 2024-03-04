package tagifyme.model;

/**
 * Base class for relationships within the database
 * @author elijah
 */
public class Relationship {
  private Data data_ref;
  private Tag tag_ref;

  /**
   * Constructor to make a relationship between tag and data.
   * @param d Data
   * @param t Tag
   */
  public Relationship(Data d, Tag t) {
    this.data_ref = d;
    this.tag_ref = t;
  }

/**
 * 
 * @return Returns Data
 */
  public Data getData() {
    return this.data_ref;
  }

  /**
   * 
   * @return Returns Tag
   */
  public Tag getTag() {
    return this.tag_ref;
  }
  
}

