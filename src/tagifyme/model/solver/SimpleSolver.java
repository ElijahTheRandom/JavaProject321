package tagifyme.model.solver;

import tagifyme.model.Relationship;
import tagifyme.model.Tag;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class SimpleSolver implements Solver {

  public List<Relationship> filter(Set<Tag> constraints, Iterable<Relationship> rel_iter) {
    ArrayList<Relationship> filtered = new ArrayList();
    for (Relationship r : rel_iter) {
      if (constraints.contains(r.getTag())) {
        filtered.add(r);
      }
    }

    return filtered;
  }
}
