package org.example.statistics;

import org.example.statistics.model.TextStatistics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextStatisticsService {
    public TextStatistics getStatistics(String text) {
        // TODO
        // Please use Streams
        String noPunctuationText = text.replaceAll("\\p{Punct}", "");
        String[] values = noPunctuationText.split(" ");
        List<String> wordsInBook= Arrays.asList(values);
        TextStatistics textStatistics= new TextStatistics();


        //WORD COUNT
        textStatistics.setWordCount((int)wordsInBook.stream().count());

        //MOST COMMON WORD

        Map<String, Long> commonWord= wordsInBook.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String MostCommonWord = Collections.max(commonWord.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getKey();
        textStatistics.setMostCommonWord(MostCommonWord);

        // LONGEST WORD
        String longest = wordsInBook.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        textStatistics.setLongestWordLength(longest.length());

        //AVERAGEWORDLENGTH
        textStatistics.setAverageWordLength(wordsInBook.stream().map(word -> word.length()).mapToDouble( wordLength -> wordLength).average().getAsDouble());

        return textStatistics;
    }
}
