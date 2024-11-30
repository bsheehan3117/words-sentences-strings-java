import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Junit tests for the ISentence interface methods.
 */

public class TestSentence {

  @Test
  public void testGetNumberOfWords() {
    ISentence sentence = new WordNode("I",
            new WordNode("like", new WordNode("chocolate",
                    new PunctuationNode(',', new WordNode("yum",
                            new EmptyNode())))));
    assertEquals(4, sentence.getNumberOfWords());
  }

  @Test
  public void testLongestWord() {
    ISentence sentence = new WordNode("Recursion",
            new PunctuationNode(',', new WordNode("this",
                    new WordNode("is", new WordNode("fun",
                            new EmptyNode())))));
    assertEquals("Recursion", sentence.longestWord());
  }

  @Test
  public void testToString() {
    ISentence sentence = new WordNode("I'm", new WordNode("wanting",
            new WordNode("to", new WordNode("go",
                    new WordNode("to", new WordNode("bed",
                            new EmptyNode()))))));
    assertEquals("I'm wanting to go to bed.", sentence.toString());
  }

  @Test
  public void testClone() {
    ISentence sentence = new WordNode("Recursion",
            new PunctuationNode(',', new WordNode("how",
                    new WordNode("fun", new EmptyNode()))));
    ISentence clone = sentence.clone();
    assertEquals("Recursion, how fun.", clone.toString());
  }

  @Test
  public void testMerge() {
    ISentence sentence1 = new WordNode("My",
            new WordNode("students", new PunctuationNode(',',
                    new WordNode("they", new WordNode("are",
                            new WordNode("crazy", new WordNode("today",
                                    new PunctuationNode('.',
                                            new EmptyNode()))))))));
    ISentence sentence2 = new WordNode("Yikes",
            new PunctuationNode(',', new WordNode("thirteen",
                    new WordNode("more", new WordNode("school",
                            new WordNode("days", new EmptyNode()))))));
    ISentence merged = sentence1.merge(sentence2);
    assertEquals("My students, they " +
            "are crazy today. Yikes, thirteen more school days.", merged.toString());
  }
}