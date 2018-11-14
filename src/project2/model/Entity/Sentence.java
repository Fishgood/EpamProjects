package project2.model.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Sentence.
 */
public class Sentence {
    /**
     * field - regex for splitting sentences
     */
    public static String splitRegex = "(?<=[.?!])";
    /**
     * field - StringBuilder to work with sentence
     */
    private StringBuilder sentence;
    /**
     * field - list of words
     */
    private List<Word> words = new ArrayList<>();
    /**
     * field - int to count words in sentence
     */
    private int wordsQuantity;

    public Sentence() {
    }

    /**
     * Instantiates a new Sentence.
     * First trim str and add in StringBuilder it, then add all splited words from sentence to {@link #words},
     * which are filtered by {@link Word#isWord(String)} and added into {@link Word} instance.
     * Also {@link #wordsQuantity} set {@link #words} size.
     * @param str the input string
     */
    public Sentence(String str) {
        this.sentence = new StringBuilder().append(str.trim());
        this.words.addAll(Arrays.stream(this.sentence.toString().split(Word.splitRegex))
                .filter(Word::isWord)
                .map(Word::new)
                .collect(Collectors.toList()));
        this.wordsQuantity = words.size();
    }

    /**
     * Get words quantity into {@link #words}
     * @return words quantity {@link #wordsQuantity}
     */
    public int getWordsQuantity() {
        return wordsQuantity;
    }

    /**
     * Get information about this instantiate
     * @return the String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        words.forEach(w -> sb.append(" ").append(w));
        return sb.toString().trim();
    }
}
