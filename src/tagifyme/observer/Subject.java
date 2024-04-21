// Files related to the observer pattern.
package tagifyme.observer;

import java.util.Set;
import tagifyme.model.Data;
import tagifyme.model.Tag;
import tagifyme.model.solver.Pair;

/**
 * Subject interface for the model; these functions handle
 * propagation of data to the View.
 */
public interface Subject {
  /**
   * Add an observer to listen for changes to the model.
   */
  void addObserver(Observer observer);

  /**
   * Propagate data upward (in this case, it's the set of
   * data to display on the table).
   */
  void notifyObservers(Iterable<Pair<Data, Set<Tag>>> d);
}
