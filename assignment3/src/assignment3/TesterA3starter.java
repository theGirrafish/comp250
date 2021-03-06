package assignment3;

// COMP 250 - Introduction to Computer Science - Fall 2017
// Assignment #3 - Question 1

import java.io.*;
import java.util.*;

// Performs lookups and word completion using the WordTree class.
// Also provides method to read from a file.

public class TesterA3starter {
    public static ArrayList<String> readWordsFromFile(String filename) {
        ArrayList<String> words = new ArrayList<String>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Strip non-alphanumeric \\W characters
            // That is, remove any characters other than a to z, A to Z, and 0 to 9

            // See https://regexone.com/lesson/character_ranges
            // which lists the '\W' symbol in the right panel as any non alphanumeric character
            // and lists the '+' symbols as meaning any non-zero number of repetitions

            scanner.useDelimiter("\\W+");

            while (scanner.hasNext())
                words.add(scanner.next());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return words;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        // You can test your code with the input file below.
        // For example, if you wish to share your outputs on the discussion board
        // that you obtained using the given text file, that's fine.

        String fileName = "C:\\Users\\Abbas\\Documents\\Code\\Workspace Java\\COMP250\\A3\\tests\\bodybuilding.txt";
        // String fileName = "C:\\Users\\Abbas\\Documents\\Code\\Workspace Java\\COMP250\\A3\\tests\\smalltest.txt";
        list = readWordsFromFile(fileName);

        // For debugging, we suggest you use a smaller set of words such as the ones shown in the PDF.

        Collections.addAll(list, "a", "and", "ax", "dog", "door", "dot", "");
        // Collections.addAll(list, "boy", "bod", "---", "G");

        WordTree wordTree = new WordTree();
        wordTree.loadWords(list);
        
        Set<String> hs = new HashSet<>();
        hs.addAll(list);

        System.out.println("list contains " + list.size() + " words");
        System.out.println("list contains " + hs.size() + " unique words");

        // Test if the contains() method works, print input and output
        // e.g.: try door, an, cat (should return true, false, and false respectively)

        System.out.println();
        System.out.println("----- Test contains() method (correct answer shown in brackets) -----" );
        System.out.println("WordTree contains 'door' = " + wordTree.contains("door") + " (true)" );
        System.out.println("WordTree contains 'and' = "  + wordTree.contains("and")  + " (true)");
        System.out.println("WordTree contains 'cat' = "  + wordTree.contains("cat")  + " (false)");
        System.out.println("WordTree contains 'dog' = "  + wordTree.contains("dog")  + " (true)");
        System.out.println("WordTree contains 'ax' = "   + wordTree.contains("ax")   + " (true)");
        System.out.println("WordTree contains 'dot' = "  + wordTree.contains("dot")  + " (true)");
        System.out.println("WordTree contains 'a' = "    + wordTree.contains("a")    + " (true)");
        System.out.println("WordTree contains 'an' = "   + wordTree.contains("an")   + " (false)");
        System.out.println("WordTree contains '' = "     + wordTree.contains("")     + " (true)");
        // System.out.println("WordTree contains 'boy' = "  + wordTree.contains("boy")  + " (true)");
        // System.out.println("WordTree contains 'BOD' = "  + wordTree.contains("BOD")  + " (false)");
        // System.out.println("WordTree contains '---' = "  + wordTree.contains("---")  + " (true)");
        // System.out.println("WordTree contains 'G' = "    + wordTree.contains("G")    + " (true)");

        // Test if getPrefix works, print input and output
        // e.g.: "door", "any", "cat" should return "door", "an", and "" respectively

        System.out.println("");
        System.out.println("----- Test getPrefix() -----");
        System.out.println("longest prefix of door = " + wordTree.getPrefix("door"));
        System.out.println("longest prefix of any = "  + wordTree.getPrefix("any"));
        System.out.println("longest prefix of cat = "  + wordTree.getPrefix("cat"));
        // System.out.println("longest prefix of --------------------------------- = " + wordTree.getPrefix("---------------------------------"));
        // System.out.println("longest prefix of BODYBUILDING = " + wordTree.getPrefix("BODYBUILDING"));

        // Test getListPrefixMatches, print input and output
        // Try prefixes "a", "do", "c" (should return [a, and, ax], [dog, door, dot], [ ] respectively)

        System.out.println("");
        System.out.println("----- Test getListPrefixMatches() (autocomplete) -----");
        System.out.println("a = "    + wordTree.getListPrefixMatches("a"));
        System.out.println("do = "   + wordTree.getListPrefixMatches("do"));
        System.out.println("c = "    + wordTree.getListPrefixMatches("c"));
        System.out.println("'' = "   + wordTree.getListPrefixMatches("").size());
        // System.out.println("prob = "  + wordTree.getListPrefixMatches("prob"));

    }
}