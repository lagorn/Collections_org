package service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTextService implements ITextService {

    @Override
    public Map<String, Long> wordsCounter(String text) {

        return getWords(text).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    @Override
    public Set<String> uniqueWords(String text) {

        return getWords(text).collect(Collectors.toSet());
    }

    @Override
    public List<String> sortWords(String text) {

        return getWords(text).distinct().sorted(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase)).collect(Collectors.toList());
    }

    private Stream<String> getWords(String text) {
        return Pattern.compile("[^\\w]+", Pattern.UNICODE_CHARACTER_CLASS).splitAsStream(text);
    }
}
