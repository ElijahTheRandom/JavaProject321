package tagifyme.model.solver;

import tagify.model.Relationship;
import java.util.List;
import java.util.Set;
import java.util.Iterable;

public class SimpleSolver implements Solver {
  public SimpleSolver {}

  public List<Relationship> filter(Set<Tag> constraints, Iterable<Relationship> rel_iter) {
    ArrayList<Relationship> filtered = new ArrayList();
    for (Relationship r : rel_iter) {
      if (constraint.contains(r.getTag())) {
        filtered.add(r);
      }
    }

    return filtered;
  }
}
