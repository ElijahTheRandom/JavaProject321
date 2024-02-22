package tagifyme.model;

public class Relationship {
  private Data data_ref;
  private Tag tag_ref;

  public Relationship(Data d, Tag t) {
    this.data_ref = d;
    this.tag_ref = t;
  }

  public Data getData() {
    return this.data_ref;
  }

  public Tag getTag() {
    return this.tag_ref;
  }
}
