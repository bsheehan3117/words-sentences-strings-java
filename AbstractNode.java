/**
 * Class Abstract Node implements the ISentence interface
 * and related methods.
 */

public abstract class AbstractNode implements ISentence {
  protected ISentence rest;

  /**
   * Constructs a Sentence.
   * @param rest The rest of the sentence.
   */

  public AbstractNode(ISentence rest) {
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    return rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    return rest.longestWord();
  }

  @Override
  public String toString() {
    return rest.toString();
  }

  @Override
  public ISentence clone() {
    return this.clone();
  }

  @Override
  public ISentence merge(ISentence other) {
    return this.merge(other);
  }
}