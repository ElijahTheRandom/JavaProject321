package tagifyme.model;

import java.io.Serializable;

// TODO: At some point, this should change into an interface
// or abstract class or something; at this point, the data is
// stored within the class itself, but it's likely that we'd
// like to point to objects on the network, the disk, whatever.

/**
 * Base class for "data" within the Database
 * @author elijah
 */

public class Data implements Comparable<Data>, Serializable {
  /** The identifier of the piece of data. */
  private final String name;
  private final String PATH;

  /**
   * 
   * @param name String name of file
   * @param PATH String PATH of file
   */
  public Data(String name, String PATH) {
    this.name = name;
    this.PATH = PATH;
  }

  /**
   * @param name String name of a file.
   */
  public Data(String name) {
    this.name = name;
    this.PATH = "Unspecified";
  }

  /**
   * 
   * @return Returns the name
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * 
   * @return Returns the PATH
   */
    public String getPATH() {
    return this.PATH;
  }

  /**
   * Compare this data to another via the Comparable interface.
     * @param other
   */
  @Override
  public int compareTo(Data other) {
    return this.getName().compareTo(other.getName());
  }

  // NOTE: Both of these Overrides are needed to have the Set functionality we
  // require; a Data should be differentiated based upon its string indentifier,
  // not its object. See the above compareTo.
  
  /**
   * Return the hashCode for this object.
   */
  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }
/**
 * .equals() overload to compare data.
 * @param obj
 * @return 
 */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    final Data other = (Data) obj;
    return this.getName().equals(other.getName());
  }
}
