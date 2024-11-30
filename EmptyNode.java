/**
 * This class represents an Empty Node.  It offers all the operations mandated by the
 * ISentence interface.
 */

public class EmptyNode extends AbstractNode {


  /**
   * Construct an EmptyNode object.
   */

  public EmptyNode() {
    super(null);
  }

  @Override
  public int getNumberOfWords() {
    return 0;
  }

  @Override
  public String longestWord() {
    return "";
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public ISentence clone() {
    return new EmptyNode();
  }

  @Override
  public ISentence merge(ISentence other) {
    return other.clone();
  }
}