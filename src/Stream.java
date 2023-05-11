import java.util.*;
import java.util.stream.*;
public class Stream {
    public static void main (String[] args) {
        List<String> strings = List.of("coffee", "tea", "", "biscuits", "muffin", "doughnut", "tea", "cookies");

        // count strings starting with "co"
        long numStartingWithCo = strings.stream()
                .filter(s -> s.startsWith("co"))
                .count();
        System.out.println("numStartingWithCo = " + numStartingWithCo); // 2

        // find any longest string; print if present
        Optional<String> longestString = strings.stream().max(Comparator.comparing(String::length));
        longestString.ifPresent(System.out::println);
        // prints either biscuits or doughnut

        // print any longest string, if present
        strings.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        // find any longest string starting with "c"
        Optional<String> longestStringStartingWithC = strings.stream()
                .filter(s -> s.startsWith("c"))
                .max(Comparator.comparing(String::length));

        System.out.println(longestStringStartingWithC.orElse("no string starting with \"c\""));

        // find length of the longest string
        OptionalInt lengthOfLongestString = strings.stream()
                .mapToInt(String::length)
                .max();
        System.out.println("lengthOfLongestString = " + lengthOfLongestString.orElseThrow());

        // get sorted list of distinct strings with length <= 6; then print the list
        List<String> shortDistinctSortedStrings = strings.stream()
                .filter(s -> s.length() <= 6)
                .distinct()
                .sorted()
                .toList();
        shortDistinctSortedStrings.forEach(System.out::println);

        // get average length of strings that start with 'c'
        OptionalDouble averageLengthOfStringsStartingWithC = strings.stream()
                .filter(s -> s.startsWith("c"))
                .mapToInt(String::length)
                .average();
        averageLengthOfStringsStartingWithC.ifPresent(System.out::println);

        // count the total number of characters (including duplicates)
        long numCharactersIncludingDuplicates = strings.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("numCharactersIncludingDuplicates = " + numCharactersIncludingDuplicates);

        // print each distinct string
        strings.stream()
                .distinct()
                .forEach(System.out::println);

        // print number of distinct strings
        System.out.println("number of distinct strings: " + strings.stream().distinct().count());

        // print each string starting with "c" in uppercase
        strings.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // print strings sorted by length, then alphabetically
        strings.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        // print a string of length 6. If there are multiple ones, print any;
        // if there are none, print nothing
        strings.stream()
                .filter(s -> s.length() == 6)
                .findAny()
                .ifPresent(System.out::println);

        // get sorted list of distinct first characters of the strings
        List<Character> firstCharacters = strings.stream()
                .filter(s -> !s.isEmpty())
                .distinct()
                .map(s -> s.charAt(0))
                .sorted()
                .toList();
        firstCharacters.forEach(System.out::println);

        // group the strings by their lengths
        Map<Integer, List<String>> map = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        map.forEach((len, wordList) -> System.out.println(len + ": " + wordList));
    }
}
