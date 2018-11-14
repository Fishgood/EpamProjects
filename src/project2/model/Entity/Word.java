package project2.model.Entity;

import java.util.regex.Pattern;

/**
 * The type Word.
 */
public class Word {


    /**
     * field - regex to split words
     */
    public static String splitRegex = "(?<=\\S\\s)";

    /**
     * field - StringBuilder to work with word
     */
    private StringBuilder word;

    public Word() {
    }


    public Word(String word) {
        this.word = new StringBuilder().append(word.trim());
    }

    /**
     * Check if input string is word
     * @param str - input string
     * @return boolean - true if str is word, otherwise false
     */
    public static boolean isWord(String str){
        return Pattern.compile("[a-zA-Z]").matcher(str).find();
    }

    /**
     * Get information about this instantiate
     * @return the String
     */
    @Override
    public String toString() {
        return this.word.toString();
    }
}
