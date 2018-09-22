package com.game.services;

import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.util.List;

public interface WordService {
    Word getRandomWord(String categoryName) throws FileNotFoundException;

    String hideWord(Word word);

    List<Integer> guessLetter(char letter, Word word);
}
