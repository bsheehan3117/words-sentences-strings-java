/**
 * This class represents a Punctuation node.  It offers all the operations mandated by the
 * ISentence interface.
 */

public class PunctuationNode extends AbstractNode {
  protected char punct;

  /**
   * Construct a WordNode object.
   * @param punct A punctuation mark.
   * @param rest The rest of the sentence.
   */

  public PunctuationNode(char punct, ISentence rest) {
    super(rest);
    this.punct = punct;
  }

  @Override
  public String toString() {

    return punct + " " + rest.toString();
  }

  @Override
  public ISentence clone() {

    return new PunctuationNode(punct, rest.clone());
  }

  @Override
  public ISentence merge(ISentence other) {
    // If other sentence is an empty node,
    // return the sentence.
    if (rest instanceof EmptyNode) {
      return new PunctuationNode(punct, other);

      // Recursively call merge until an empty node is reached
      // then return the merged sentence.
    } else {
      return new PunctuationNode(punct, rest.merge(other));
    }
  }
}