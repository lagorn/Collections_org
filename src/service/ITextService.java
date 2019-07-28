package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ITextService {

    Map <String, Long> wordsCounter (String text);

    Set <String> uniqueWords (String text);

    List<String> sortWords (String text);

}
