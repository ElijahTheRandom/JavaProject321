// Files related to the observer pattern.
package tagifyme.observer

public interface Observer {
  // TODO: What's the proper way to hande an Observer update for
  // multiple types? Consider an update that has table data,
  // vs other data; How is this handled?
  // What should this data type be?
  void update(Object[] p);
}
