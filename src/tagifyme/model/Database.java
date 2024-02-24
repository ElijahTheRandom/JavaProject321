package tagifyme.model;

import java.util.Set;
import java.util.HashSet;

// TODO: Abstract this later with inheritance, etc.
public class Database {

  // Each of these are Sets to avoid duplication.
  private Set<Data> data_set;
  private Set<Tag> tag_set;
  private Set<Relationship> relationship_set;

  public Database() {
    this.data_set = new HashSet<Data>();
    this.tag_set  = new HashSet<Tag>();
    this.relationship_set = new HashSet<Relationship>();
  }

  /**
   * Alternative constructor that allows for pre-computed data, tag, relationship
   * parameters.
   */
  public Database(HashSet<Data> d, HashSet<Tag> t, HashSet<Relationship> r) {
    this.data_set = d;
    this.tag_set = t;
    this.relationship_set = r;
  }
  
  public void addTag(Tag t) {
    this.tag_set.add(t);
  }
  
  public void deleteTag(Tag t) {
      // TODO: Implementation to delete a tag from the database.
      // NOTE: this has to delete the accompanying relationships aswell.
  }
  
  public void addData(Data d) {
    this.data_set.add(d);
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
