package com.game.services;

import com.game.entities.Word;
import com.game.repositories.WordRepository;
import com.game.repositories.WordRepositoryImpl;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    public WordServiceImpl() throws FileNotFoundException {
        this.wordRepository = new WordRepositoryImpl();
    }

    @Override
    public Word getRandomWord(String categoryName) throws FileNotFoundException {
        Random rand = new Random();
        List<Word> words = wordRepository.getWordsByCategoryName(categoryName);
        if (words.size() == 0){
            return null;
        }

        int randomWordIndex = rand.nextInt(words.size());
        return words.get(randomWordIndex);
    }

    @Override
    public String hideWord(Word word) {
        char[] lettersArray = word.getName().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lettersArray.length; i++) {
            if (Character.isSpaceChar(lettersArray[i])){
                sb.append(" ");
            } else {
                sb.append("_ ");
            }
        }

        return sb.toString();
    }

    @Override
    public List<Integer> guessLetter(char letter, Word word) {
        int indexer = 0;
        List<Integer> occurrenceIndices = new ArrayList<>();
        char[] lettersArray = word.getName().toLowerCase().toCharArray();

        for (int i = 0; i < lettersArray.length; i++) {
            if (lettersArray[i] == Character.toLowerCase(letter)){
                if (i == 0){
                    occurrenceIndices.add(i);
                } else if(i != lettersArray.length){
                    occurrenceIndices.add(indexer);
                } else {
                    occurrenceIndices.add(indexer - 2);
                }

            } else if (Character.isWhitespace(lettersArray[i])){
                indexer --;
            }

            indexer += 2;
        }

        return occurrenceIndices;
    }

    @Override
    public String revealLetters(char letter, List<Integer> letterIndices, String word){
        char[] wordLetters = word.toCharArray();
        for (Integer index : letterIndices) {
            wordLetters[index] = letter;
        }

        return String.valueOf(wordLetters);
    }

    @Override
    public boolean isGameFinished(String word){
        boolean isFinished = false;
        if(!word.contains("_")){
            isFinished = true;
        }

        return isFinished;
    }
}
