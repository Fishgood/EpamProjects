package project2.model;

import project2.model.Entity.Sentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Text parser.
 */
public class TextParser {
    private List<Sentence> sentences = new ArrayList<>();

    public TextParser() {
    }

    /**
     * Constructor - add all splited sentences to {@link #sentences}
     * @param str input string
     */
    public TextParser(String str) {
        this.sentences.addAll(Arrays.stream(str.split(Sentence.splitRegex))
                .map(Sentence::new)
                .collect(Collectors.toList()));
    }

    /**
     * Sort {@link #sentences} by words
     */
    public void sortByWords() {
        this.sentences = sentences.stream()
                .sorted(Comparator.comparing(Sentence::getWordsQuantity))
                .collect(Collectors.toList());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sentences.forEach(s -> sb.append(s).append(" "));
        return sb.toString();
    }
}
