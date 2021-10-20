package ru.alexanna.lesson_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Task #1
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "six", "eleven", "nine", "twelve", "ten", "fourteen", "four", "six", "one", "fourteen"};
        Map<String, Integer> dictionary = calculateWords(words);
        printDictionary(dictionary);

        System.out.println();

        // Task #2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "111-22-33");
        phonebook.add("Petrov", "222-33-44");
        phonebook.add("Sidorov", "333-44-55");
        phonebook.add("Ivanov", "444-55-66");
        phonebook.add("Petrov", "555-66-77");

        List<String> phoneNumbersIvanov = phonebook.get("Ivanov");
        List<String> phoneNumbersSidorov = phonebook.get("Sidorov");
        List<String> phoneNumbersPetrov = phonebook.get("Petrov");
        List<String> phoneNumberJohnson = phonebook.get("Johnson");

        System.out.println("Ivanov phone number: " + phoneNumbersIvanov);
        System.out.println("Sidorov phone number: " + phoneNumbersSidorov);
        System.out.println("Petrov phone number: " + phoneNumbersPetrov);
        System.out.println("Johnson phone number: " + phoneNumberJohnson);
    }

    public static Map<String, Integer> calculateWords(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer counter = wordsMap.getOrDefault(words[i], 0) + 1;
            wordsMap.put(words[i], counter);
        }
        return wordsMap;
    }

    public static void printDictionary(Map<String, Integer> dictionary) {
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println("The word '" + entry.getKey() + "' has " + entry.getValue() + " occurrences");
        }
    }
}
