/**
 * This class represents a Word Node.  It offers all the operations mandated by the
 * ISentence interface.
 */

public class WordNode extends AbstractNode {
  protected String word;

  /**
   * Construct a WordNode object.
   * @param word A word.
   * @param rest The rest of the sentence.
   */


  public WordNode(String word, ISentence rest) {
    super(rest);
    this.word = word;
  }

  @Override
  public int getNumberOfWords() {
    return 1 + this.rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {

    // Get the length of an individual word, store as wordLength.
    int wordLength = getWordLength(word);
    // Call longest word on rest then call get word length.
    int restLength = getWordLength(rest.longestWord());

    // If word Length is greater than the words in the rest
    // of the sentence, return the word.  Recursively call
    // rest.longestWord until true.
    if (wordLength > restLength) {
      return word;
    } else {
      return rest.longestWord();
    }
  }

  /**
   * Helper method determines the length of a word.
   *
   * @param word The word to find the length of.
   * @return The length of the word as an integer.
   */
  public int getWordLength(String word) {

    // Recursively call getWordLength until a space between the
    // words is reached.
    if (word.equals("")) {
      return 0;
    } else {
      return 1 + getWordLength(word.substring(1));
    }
  }

  @Override
  public String toString() {

    // If next node is empty, return the last word and .
    if (rest instanceof EmptyNode) {
      return word + ".";

      // Check for punctuation.
    } else if (rest instanceof PunctuationNode) {
      return word + rest;

      // Run toString recursively until an empty node is reached.
    } else {
      return word + " " + rest.toString();
    }
  }

  @Override
  public ISentence clone() {
    return new WordNode(word, rest.clone());
  }

  @Override
  public ISentence merge(ISentence other) {

    // Check if the rest is an empty node.
    if (rest instanceof EmptyNode) {
      return new WordNode(word, other);

      // Run merge recursively until other reaches an empty node.
    } else {
      return new WordNode(word, rest.merge(other));
    }
  }
}