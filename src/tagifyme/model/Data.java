package tagifyme.model;

// TODO: At some point, this should change into an interface
// or abstract class or something; at this point, the data is
// stored within the class itself, but it's likely that we'd
// like to point to objects on the network, the disk, whatever.

public class Data {
  /** The identifier of the piece of data. */
  private String name;

  // Where buf is the underlying data associated with the
  // type.
  private String buf;

  public Data(String name, String buf) {
    this.name = name;
    this.buf = buf;
  }

  public String getName() {
    return this.name;
  }

  public String getBuf() {
    return this.buf;
  }
}
