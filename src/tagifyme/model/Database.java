/** Core database class.
 */
package tagifyme.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.HashMap;

import tagifyme.observer.Subject;
import tagifyme.observer.Observer;
import tagifyme.model.solver.Pair;
import tagifyme.model.solver.SimpleSolver;

/**
 * A `Database` composes some `Data`, some `Tag`s, and some
 * `Relationship`.
 * @author team 8
 */
public class Database implements Subject, Serializable {

  // Utilize `Set` classes to avoid duplication.
  private Set<Data> data_set;
  private Set<Tag> tag_set;
  private Set<Relationship> relationship_set;

  // Observer pattern requirements.
  private transient List<Observer> obs_list;

  /**
   * Construct a Database with nothing in it.
   */
  public Database() {
    this.data_set = new HashSet<Data>();
    this.tag_set  = new HashSet<Tag>();
    this.relationship_set = new HashSet<Relationship>();

    this.obs_list = new ArrayList<Observer>();
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
   * Alternative constructor that allows for populating the `Database` with types from
   * `Iterable`.
   * @param dI An Optional iterable of Data.
   * @param tI An Optional iterable of Tags.
   * @param rI An Optional iterable of Relationships.
   */
  public Database(Optional<Iterable<Data>> dI, Optional<Iterable<Tag>> tI, Optional<Iterable<Relationship>> rI) {
    this(); // Call the parameter-less constructor, initializing the sets.

    if (dI.isPresent()) {
      for (Data elem : dI.get()) {
        this.data_set.add(elem);
      }
    }

    if (tI.isPresent()) {
      for (Tag elem : tI.get()) {
        this.tag_set.add(elem);
      }
    }

    // TODO: What to do if there's no Data, no Tags, but there are Relationships?
    if (rI.isPresent()) {
      for (Relationship elem : rI.get()) {
        this.relationship_set.add(elem);
      }
    }
  }
  
  /**
   * Add a tag to the Database.
   * @param t Tag
   */
  public void addTag(Tag t) {
    this.tag_set.add(t);
  }

  /**
   * Delete a tag from the Database.
   * @param t Tag to delete
   */
  public void deleteTag(Tag t) {
    this.tag_set.remove(t); // Remove the tag from the set.

    // If we're deleting a Tag, we need to delete the accompanying relationships.
    // To avoid a ConcurrentModificationException, find
    // ALL of the relationships that need to be deleted, then delete them.

    ArrayList<Relationship> toDelete = new ArrayList();

    for (Relationship r : this.relationship_set) {
      if (r.getTag().equals(t)) {
        toDelete.add(r);
      }
    }

    // Now delete those that matched.
    for (Relationship r : toDelete) {
      this.relationship_set.remove(r);
    }

    // Propagate changes up to the view.
    this.notifyObservers(this.allData());
  }
  
  /**
   * Add Data to the Database.
   * @param d Data.
   */
  public void addData(Data d) {
    this.data_set.add(d);

    // Propagate changes up to the view.
    this.notifyObservers(this.allData());
  }
  
  /**
   * Delete a piece of data.
   * 
   * This will also delete its relationship to a tag.
   * @param d Data to delete
   */
  public void deleteData(Data d) {
    this.data_set.remove(d); // Remove the data from the set.

    // If we're deleting data, we need to delete the accompanying
    // relationships. To avoid a ConcurrentModificationException, find
    // ALL of the relationships that need to be deleted, then delete them.
  
    ArrayList<Relationship> toDelete = new ArrayList();

    for (Relationship r : this.relationship_set) {
      if (r.getData().equals(d)) {
        toDelete.add(r);
      }
    }

    // Now delete those that matched.
    for (Relationship r : toDelete) {
      this.relationship_set.remove(r);
    }

    // Propagate changes up to the view.
    this.notifyObservers(this.allData());
  }
  
  /**
   * Add a Relationship into the Database.
   * @param rel new Relationship
   */
  public void addRelationship(Relationship r) {
    this.relationship_set.add(r);

    // Propagate changes up to the view.
    this.notifyObservers(this.allData());
  }
  
  /**
   * Delete a Relationship from the Database.
   * @param rel Relationship to delete
   */
  public void deleteRelationship(Relationship r) {
    this.relationship_set.remove(r);

    // Propagate changes up the view.
    this.notifyObservers(this.allData());
  }

  /**
   * Offer up the Data and its associated Tags.
   */
  public Iterable<Pair<Data, Set<Tag>>> allData() {
    // TODO: This function is absolutely miserable; at its current
    // implementation, it iterates over the Relationship set multiple
    // times. What should be done is the following.
    // 1) Allocate some HashMap from `Data` -> `List<Tag>`.
    // 2) Iterate over the `Relationship` set, populating the previously
    // allocated HashMap.
    // 3) Iterate over the `Data` set, adding all pieces of `Data` that
    // don't have a `Relationship`.

    // TODO: Should have used a HashMap!

    List<Pair<Data, Set<Tag>>> r = new ArrayList();
    for (Data d_elem: this.data_set) {
      // find the set of tags associated with this element of data.
      Set<Tag> tags = new HashSet();

      for (Relationship r_elem : this.relationship_set) {
        if (r_elem.getData().equals(d_elem)) {
          tags.add(r_elem.getTag());
        }
      }

      r.add(new Pair(d_elem, tags));
    }

    return r;
  }

  // TODO: Major issues with this function and the above; the other is in the
  // form of returning an iterable, and this one is notifying the observers!
  // Some more thought, time, and most importantly care should have been
  // thrown here.

  /**
   * Offer up the Data and associated tags that satisfy the constraints.
   */
  public void filteredData(Set<Tag> constraints) {
    SimpleSolver solv = new SimpleSolver();
    List<Relationship> satisfied = solv.filter(constraints, this.relationship_set);

    HashMap<Data, Set<Tag>> hm = new HashMap();
    for (Relationship r : satisfied) {
      // If the Data doesn't exist within the HashMap yet, insert it.
      // TODO: Holy smokes this is ugly! FIX
      if (hm.get(r.getData()) == null) {
        hm.put(r.getData(), new HashSet());
        Set<Tag> hs = hm.get(r.getData());
        hs.add(r.getTag());
      } else {
        Set<Tag> hs = hm.get(r.getData());
        hs.add(r.getTag());
      }
    }

    // Convert the HashMap into a Iterable<Pair<Data, Set<Tag>>> which
    // should have been a HashMap!

    List<Pair<Data, Set<Tag>>> r = new ArrayList();
    for (Data d : hm.keySet()) {
      r.add(new Pair(d, hm.get(d)));
      System.out.println(d.getName());
    }

    // Propagate up the model.
    this.notifyObservers(r);
  }

  
  /**
   * Return the `Tag`s within the `Database`.
   * @return an iterable of all tags
   */
  public Iterable<Tag> allTags(){
      return tag_set;
  }
  
  // TODO: I don't know why this is needed.
  // This might just be a `contains`?
  /**
   * 
   * @param name String 
   * @return the name of a specific tag in the list of tags
   */
  public Tag getTag(String name){
    int i = 0;
    for (Tag tag : tag_set ){
        if(tag.getName().equals(name)){
            return tag;
        };
    }
    return new Tag("Undefined");
  }

  /**
   * Notify all observers that the model has changed, offering up
   * a list of all the `Data` and `Tags`.
   * @param d data to push upward to the view.
   */
  public void notifyObservers(Iterable<Pair<Data, Set<Tag>>> d) {
    for (Observer obs: this.obs_list) {
      obs.update(d);
    }
  }

  /**
   * Add an Observer to listen for changes.
   */
  public void addObserver(Observer obs) {
      // When we're deserializing the object and loading from disk, this
      // `obs_list` is not necessarily initialized (it's passed over because
      // it's transient); initialize it if it doesn't exist.
      if (this.obs_list == null) {
        this.obs_list = new ArrayList<Observer>();
      }

      this.obs_list.add(obs);

      // We've added an observer, go ahead and update it with
      // the table.
      obs.update(this.allData());
  }
}
