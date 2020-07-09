package amazonQuestions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sumit Deo
 */
public class Ques1 {

    public static void main(String[] args) {

        String helpText = "Purchase Order Item Help can't find item " +
                "item is too much part of purchase need fix for image " +
                "item delivered too fast " +
                "purchase order too big is purchase order coming? " +
                "too big why";

        String [] wordsToExclude = {"help", "fix", "too", "is", "of"};

        Set<String> mostUsedWords = getMostUsedWords(helpText, wordsToExclude);

        for (String word : mostUsedWords) {
            System.out.println(word);
        }
    }

    private static Set<String> getMostUsedWords(String helpText, String[] wordsToExclude) {
        String[] listOfWords = helpText.toLowerCase().replaceAll("[^a-z']", " ").split(" ");
        HashMap<String, Integer> wordsFreq = new HashMap<>();
        for (String word : listOfWords) {
            boolean shouldBeKept = true;
            for (String wordToExclude : wordsToExclude) {
                if (word.equals(wordToExclude)) {
                    shouldBeKept = false;
                    break;
                }
            }
            if (shouldBeKept) {
                wordsFreq.put(word, (wordsFreq.containsKey(word) ? wordsFreq.get(word) : 0) + 1);
            }
        }

        Integer max = Collections.max(wordsFreq.values());
        Integer finalMax = max;
        List listOfMax = wordsFreq.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == finalMax)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(listOfMax);
        max = Collections.max(wordsFreq.values());
        Iterator iterator = wordsFreq.keySet().iterator();
        Set<String> result = new HashSet<>();
        while (iterator.hasNext()) {
            String word = (String) iterator.next();
            if (wordsFreq.get(word) == max) {
                result.add(word);
            }
        }
        return result;
    }
}
