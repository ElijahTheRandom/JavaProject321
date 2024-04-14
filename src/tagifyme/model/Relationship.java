/* Within the database the 'Relationship' is the mapping
 * between the 'Data' and the 'Tag'.
 */
package tagifyme.model;
import java.io.Serializable;

/**
 * A `Relationship` associates some `Data` with a `Tag`.
 */
public class Relationship implements Serializable {
  // data_ref <-> tag_ref;
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
 * Return the `Data` portion of the `Relationship`.
 * @return return the `Data`.
 */
  public Data getData() {
    return this.data_ref;
  }

  /**
   * Return the `Tag` portion of the `Relationship`.
   * @return return the `Tag`.
   */
  public Tag getTag() {
    return this.tag_ref;
  }
}
