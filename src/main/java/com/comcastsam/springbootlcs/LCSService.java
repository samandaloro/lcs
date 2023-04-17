package com.comcastsam.springbootlcs;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LCSService {

    /*
    Here is an overview of our algorithm to calculate the LCS of our set of Strings.
    1. Find the shortest string, and create a Set of ALL of its substrings
    2. Cycle through the strings, removing the substrings that are NOT a fit for the current string from the Set
    3. This leaves only the substrings that fit all the words. Find the largest one(s) and return
     */
    public ArrayList<Value> findLCS(List<Value> values) {
        //Convert from Value type to String
        ArrayList<String> words = convertValueToString(values);

        //List to hold lcs value(s)
        List<String> lcs = new ArrayList<>();

        //1. Verify that the list is not empty
        if (words.size() == 0) {
            throw new RuntimeException("setOfStrings cannot be empty");
        }

        //2. Verify that the list is a valid set (all unique values)
        //Time Complexity; O(n) where n is the length of words
        Set<String> unique = new HashSet<>();
        for(String word : words) {
            if (word.length() == 0) {
                throw new RuntimeException("setOfStrings cannot contain empty values");
            }
            if (unique.contains(word)) {
                throw new RuntimeException("setOfStrings must be a set");
            }
            unique.add(word);
        }

        //3. Find the shortest word, since the LCS cannot be longer than the shortest string
        // Time Complexity: O(n) where n is the length of words
        String shortestWord = words.get(0);
        for(String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        //4. Get all of its substrings, add it to Set
        // Time Complexity: O(n^2) where n is the length of the shortest string
        Set<String> substrings = new HashSet<>();
        for(int i=0; i<shortestWord.length(); i++) {
            for(int j=i+1; j<=shortestWord.length(); j++) {
                substrings.add(shortestWord.substring(i, j));
            }
        }

        //5. Cycle through all words, add matching substrings to a temp set, then replace the set with the temp set
        // Time Complexity : O(n^2*m*k) where n is length of shortest string, m is length of words, k is length of longest string
        for(String word: words) {
            Set<String> tempSet = new HashSet<>();
            for(String sub: substrings) {
                if (word.contains(sub)) {
                    tempSet.add(sub);
                }
            }
            substrings = tempSet;
        }

        //6. Find the max substring length
        // Time Complexity: O(n) where n is the length of substrings
        int maxSubstringLength = 0;
        for(String sub: substrings) {
            maxSubstringLength = Math.max(maxSubstringLength, sub.length());
        }

        //7. Add substrings of max length to our List
        // Time Complexity: O(n) where n is the length of substrings
        for(String sub: substrings) {
            if (sub.length() == maxSubstringLength) {
                lcs.add(sub);
            }
        }

        //8. Sort by alphabetical order
        // Time Complexity: O(nlogn) where n is the length of lcs
        Collections.sort(lcs);
        return convertStringToValue(lcs);

    }
    /* This method converts our Value objects to Strings */
    private ArrayList<String> convertValueToString(List<Value> values) {
        ArrayList<String> list = new ArrayList<>();
        for(Value v : values) {
            list.add(v.getValue());
        }
        return list;
    }

    /* This method converts Strings to our Value objects to be returned */
    private ArrayList<Value> convertStringToValue(List<String> strings) {
        ArrayList<Value> list = new ArrayList<>();
        for(String s : strings) {
            list.add(new Value(s));
        }
        return list;
    }

}
