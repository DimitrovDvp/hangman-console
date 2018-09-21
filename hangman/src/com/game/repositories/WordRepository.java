package com.game.repositories;

import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.util.List;

public interface WordRepository extends BaseRepository{
    List<Word> getWordsByCategoryName(String categoryName) throws FileNotFoundException;
}
