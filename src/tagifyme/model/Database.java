package tagifyme.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// TODO: Abstract this later with inheritance, etc.
public class Database {

  // TODO: `List` seems to be the minimum amount of specificity
  // that we could use, but there's benefits to using an ordered list.
  // Does the stdlib have anything like this in-built?
  private List<Data> data_list;
  private List<Tag>  tag_list;
  private List<Relationship> relationship_list;

  public Database() {
    this.data_list = new ArrayList<Data>();
    this.tag_list = new ArrayList<Tag>();
    this.relationship_list = new ArrayList<Relationship>();
  }

  public static Database loadDatabase() throws Exception {
    // TODO: Load a database from a file.
    throw new Exception("TODO");
  }

  public void dumpDatabase() {
    // TODO: Write the database to disk.
  }

  // TODO: At some point, when feeding to a view, we'll need to iterate
  // over the entirety of the data.

  public Iterator<Data> getData() {
    return this.data_list.iterator();
  }

  public Iterator<Tag> getTag() {
    return this.tag_list.iterator();
  }

  public Iterator<Relationship> getRelationship() {
    return this.relationship_list.iterator();
  }
}
