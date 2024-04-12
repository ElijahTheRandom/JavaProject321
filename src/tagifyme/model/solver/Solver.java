package tagifyme.model.solver;

import tagifyme.model.Relationship;
import tagifyme.model.Tag;
import java.util.List;
import java.util.Set;

public interface Solver {
  public List<Relationship> filter(Set<Tag> constraints, Iterable<Relationship> rel_iter);
}
