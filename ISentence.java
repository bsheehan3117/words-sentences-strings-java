/**
 * This interface represents all the operations to be supported by a sentence.
 */

public interface ISentence {
  /**
   * Computes and returns the number of words in the sentence. The punctuation does
   * not count as a word.
   *     @return The number of words in the sentence as int.
   */
  int getNumberOfWords();

  /**
   * Determines and returns the longest word in the sentence. The word returned is
   * just the word with no punctuation. If the sentence
   * contains no words, the method should return an empty string.
   *     @return The longest word in the sentence as a String.
   */
  String longestWord();

  /**
   * Converts the sentence into one string. There is a space between every two
   * words. A punctuation mark should have no space between it and whatever
   * precedes it. There is no space between the last word and the end of this
   * sentence. If there is no punctuation mark at the end of the sentence, the
   * string should end with a period.
   *     @return The string representation of the sentence.
   */
  String toString();

  /**
   * Returns a duplicate of the sentence.  It has the same words and
   * punctuation as the original list, but is independent.
   *     @return A duplicate of the sentence.
   */
  ISentence clone();

  /**
   * Merges two sentences into a single sentence. The merged list should preserve
   * all the punctuation. The merged list should be returned by this method, and
   * the original lists should be unchanged.
   *     @param other Another sentence to merge with.
   *     @return The merged sentence as Sentence.
   */
  ISentence merge(ISentence other);
}