package tagifyme.model.solver;
import java.util.Optional;

/** An Either type that contains either the left or the right. */
public class Either<L, R> {
  private final Optional<L> left;
  private final Optional<R> right;

  private Either(Optional<L> left, Optional<R> right) {
    this.left  = left;
    this.right = right;
  }

  /** Build a new Either with the left set. */
  public static <L, R> Either<L, R> left(L left) {
    return new Either<>(Optional.of(left), Optional.empty());
  }

  /** Build a new Either with the right set. */
  public static <L, R> Either<L, R> right(R right) {
    return new Either<>(Optional.empty(), Optional.of(right));
  }

  /** Return whether the 'left' is set. */
  public boolean isLeft() {
    return this.left.isPresent();
  }

  /** Return the value in 'left'. */
  public L left() {
    return this.left.get();
  }

  /** Return the value in 'right'. */
  public R right() {
    return this.right.get();
  }
}
