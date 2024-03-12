package tagifyme.model.solver;

public class Pair<L, R> {
  private final L left;
  private final R right;
  
  /** Create a Pair. */
  public Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  /** Return the left of a Pair. */
  public L left() {
    return this.left;
  }

  /** Return the right of a Pair. */
  public R right() {
    return this.right;
  }
}
