package service;

import java.util.*;

public class StandartTextService implements ITextService {

    @Override
    public Map<String, Long> wordsCounter(String text) {

        Map<String, Long> result = new HashMap<>();

        List<String> list = getWords(text);

        for (String word : list) {
            if (!result.containsKey(word)) {
                result.put(word, (long) Collections.frequency(list, word));
            }
        }

        return result;
    }

    @Override
    public Set<String> uniqueWords(String text) {

        return new HashSet<>(getWords(text));
    }

    @Override
    public List<String> sortWords(String text) {

        List<String> result = new ArrayList<>(uniqueWords(text));

        result.sort((o1, o2) -> o1.length() != o2.length() ? (o1.length() > o2.length() ? 1 : -1) : o1.compareTo(o2));

        return result;
    }

    private List<String> getWords(String text) {
        return Arrays.asList(text.split("[^a-zA-Zа-яА-Я0-9]+"));
    }
}
