package tagifyme.model.solver;

import java.util.Set;
import java.util.HashSet;
import tagifyme.model.Tag;

/**
 * A Parser that expects the Tags to be comma separated values.
 */
public class CSVParser {

  /** Given a String, return the appropriate tags. */
  public static Set<Tag> parse(String s) {
    Set<Tag> r = new HashSet();
    for (String name : s.split(",")) {
      r.add(new Tag(name));
    }

    return r;
  }
}
