package tagifyme.model.solver;
import tagifyme.model.Relationship;
import java.util.List;

public interface Solver {
  public List<Relationship> filter(Constraint c);
}
