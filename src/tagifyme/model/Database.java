package tagifyme.model;

import java.util.List;
import java.util.ArrayList;

// TODO: Abstract this later with inheritance, etc.
public class Database {

  // TODO: These are lists at this point, but there's cases where we don't want
  // to add duplicate tags within the database, etc. There's the case where
  // we potentially want these ordered to allow for faster searching.
  // Select some type, and then figure it out later.
  private List<Data> data_list;
  private List<Tag> tag_list;
  private List<Relationship> relationship_list;

  public Database() {
    // See the above TODO.
    this.data_list = new ArrayList<Data>();
    this.tag_list = new ArrayList<Tag>();
    this.relationship_list = new ArrayList<Relationship>();
  }
  
  public void addTag(Tag t) {
      // TODO: Add a tag to the databse.
  }
  
  public void deleteTag(Tag t) {
      // TODO: Implementation to delete a tag from the database.
      // NOTE: this has to delete the accompanying relationships aswell.
  }
  
  public void addData(Data dt) {
      // TODO: Add data to the database.
  }
  
  // TODO: Does this take a Data (an object reference), or does it take
  // an index into the data type that stores the relationship?
  public void deleteData(Data dt) {
      // TODO: Remove specific data from the database; NOTE, this should
      // destroy the accompanying relationships within the database aswell.
  }
  
  public void addRelationship(Relationship rel) {
      // TODO: Implementation to add the specific relationship to the
      // database.
  }
  
  // TODO: Does this take a Relationship (an object reference), or does it
  // take an index into the data type that stores the relationship?
  public void deleteRelationship(Relationship rel) {
      // TODO: Implementation to remove the specific relationship from the
      // database.
  }
 

  public static Database loadDatabase() throws Exception {
    // TODO: Load a database from a file.
    throw new Exception("TODO");
  }

  public void dumpDatabase() {
    // TODO: Write the database to disk.
  }
}
