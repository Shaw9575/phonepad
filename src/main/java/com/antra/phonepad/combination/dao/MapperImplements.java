package com.antra.phonepad.combination.dao;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

@Repository("ToLetterMapper")
public class MapperImplements implements ToLetterMapper{

    private Set<String> wordsSet;
    private Map<String, String> phone;

    public MapperImplements() throws IOException {
        phone = new HashMap<>();
        phone.put("1", "1");
        phone.put("0", "0");
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        Path path = Paths.get("src/main/resources/words.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, StandardCharsets.UTF_8).toLowerCase();
        String[] words = wordListContents.split("\n");
        wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
    }
    @Override
    public List<String> toLetterMapper(String digits) {
        List<String> output = test(digits);
        return output;
    }

    public List<String>  test (String digits) {
        List<String> seg = new ArrayList<String>();
        seg.add(digits.substring(0, 3));
        seg.add(digits.substring(3, 6));
        seg.add(digits.substring(6, 10));
        ArrayList<List<String>> results = new ArrayList<>();
        for (String s : seg) {
            List<String> output = new ArrayList<>();
            if (s.length() != 0) {
                backtrack("", s, output);
            }
            List<String> outputWords = new ArrayList<>();
            for (String words: output) {
                if (isValidWord(words)) {
                    outputWords.add(words);
                }
            }
            if (outputWords.isEmpty()) {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                results.add(temp);
            } else {
                results.add(outputWords);
            }
        }
        System.out.println(results);
        List<String> response = new ArrayList<>();
        resultRecur("", 0, response, results);
        System.out.println(response);
        return response;
    }

    private void resultRecur(String telephone, int nextIndex, List<String> response, ArrayList<List<String>> results){
        if (nextIndex == 3) {
            response.add(telephone);
        } else {
            for (int i = 0; i < results.get(nextIndex).size(); i ++) {
                resultRecur(telephone + results.get(nextIndex).get(i), nextIndex + 1, response, results);
            }
        }
    }

    private void backtrack(String combination, String nextDigits, List<String> output) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        }
        else {
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1), output);
            }
        }
    }

    public boolean isValidWord(String word)
    {
        return wordsSet.contains(word);
    }
}
