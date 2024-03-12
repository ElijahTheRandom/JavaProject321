package tagifyme.model.solver;

import tagifyme.model.Tag;
import java.util.ArrayList;
import java.util.Optional;

public class Constraint {
  enum Connective {
    IS,
    NOT,
  };

  private ArrayList<Either<Constraint, Pair<Optional<Connective>, Tag>>> constraints;

  public Constraint() {
    this.constraints = new ArrayList();
  }
}
