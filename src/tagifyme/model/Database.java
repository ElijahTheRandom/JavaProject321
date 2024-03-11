package tagifyme.model;

import java.util.Set;
import java.util.HashSet;

// TODO: Abstract this later with inheritance, etc.

/**
 * Base class of the Database
 * @author elijah
 */
public class Database {

  // Each of these are Sets to avoid duplication.
  private Set<Data> data_set;
  private Set<Tag> tag_set;
  private Set<Relationship> relationship_set;

    /**
     *
     */
    public Database() {
    this.data_set = new HashSet<Data>();
    this.tag_set  = new HashSet<Tag>();
    this.relationship_set = new HashSet<Relationship>();
  }

  /**
   * Alternative constructor that allows for pre-computed data, tag, relationship
   * parameters.
   * @param d Data Hash set
   * @param t Tag Hash set
   * @param r Relationship Hash set
   */
  public Database(HashSet<Data> d, HashSet<Tag> t, HashSet<Relationship> r) {
    this.data_set = d;
    this.tag_set = t;
    this.relationship_set = r;
  }
  
  /**
   * Creates a tag
   * @param t Tag
   */
  public void addTag(Tag t) {
    //TODO? Add a handler for subtags?
    this.tag_set.add(t);
  }
  /**
   * Change the tag of some data.
   * @param d Data
   * @param t New Tag
   */
  public void changeTag(Data d, Tag t) {
    //TODO: Change tags of the data. Whether that be generating "new" data and
    //deleting old data or something else of that nature
  }
  
  /**
   * Delete tag
   * @param t Tag to delete
   */
  public void deleteTag(Tag t) {
    this.tag_set.remove(t); // Remove the tag from the set.

    // If we're deleting a Tag, we need to delete the accompanying
    // relationships.
    for (Relationship r : this.relationship_set) {
      if (r.getTag().equals(t)) {
        // TODO: If we're deleting a tag, what's the risk of modifying the underlying
        // set we're iterating over?
        this.relationship_set.remove(r);
      }
    }
  }
  
  /**
   * Add data to our data set
   * @param d new Data
   */
  public void addData(Data d) {
    this.data_set.add(d);
  }
  
  // TODO: Does this take a Data (an object reference), or does it take
  // an index into the data type that stores the relationship?
  // Definitely should take a data object and we can work from there - elijah
  /**
   * Delete a piece of data.
   * This will also delete its relationship to a tag.
   * @param d Data to delete
   */
  public void deleteData(Data d) {
    this.data_set.remove(d); // Remove the data from the set.

    // If we're deleting data, we need to delete the accompanying
    // relationships.
    for (Relationship r : this.relationship_set) {
      if (r.getData().equals(d)) {
        // TODO: If we're deleting data, what's the risk of modifying the underlying
        // set we're iterating over?
        this.relationship_set.remove(r);
      }
    }
  }
  
  /**
   * Add a relationship between a tag and data.
   * @param rel new Relationship
   */
  public void addRelationship(Relationship rel) {
      // TODO: Implementation to add the specific relationship to the
      // database.
  }
  
  // TODO: Does this take a Relationship (an object reference), or does it
  // take an index into the data type that stores the relationship?
  // def should take an object reference  - elijah
  /**
   * Delete a relationship between a tag and data.
   * @param rel Relationship to delete
   */
  public void deleteRelationship(Relationship rel) {
      // TODO: Implementation to remove the specific relationship from the
      // database.
  }
 
  /**
   * Will load the database from a file
   * @return a loaded Database
   * @throws Exception TODO
   */
  public static Database loadDatabase() throws Exception {
    // TODO: Load a database from a file.
    throw new Exception("TODO");
  }

  /**
   * Will write all information to the database.
   */
  public void dumpDatabase() {
    // TODO: Write the database to disk.
  }
}
