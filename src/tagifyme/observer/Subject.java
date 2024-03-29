// Files related to the observer pattern.
package tagifyme.observer

public interface Subject {
  // Add an observer to the list.
  void addObserver(Observer observer);
  void notifyObservers();
}
