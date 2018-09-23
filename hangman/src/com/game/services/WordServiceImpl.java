package com.game.services;

import com.game.entities.Word;
import com.game.repositories.WordRepository;
import com.game.repositories.WordRepositoryImpl;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<Integer> occurrenceIndices = new ArrayList<>();
        char[] lettersArray = word.getName().toLowerCase().toCharArray();

        int indexer = 0;
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
}
