package tagifyme.model.solver;

import tagifyme.model.Relationship;
import java.util.List;
import java.util.Set;
import java.util.Iterable;

public interface Solver {
  public List<Relationship> filter(Set<Tag> constraints, Iterable<Relationship> rel_iter);
}
