package com.game.repositories;

import com.game.entities.Category;
import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordRepositoryImpl implements WordRepository {

    private final CategoryRepository categoryRepository;

    public WordRepositoryImpl() throws FileNotFoundException {
        categoryRepository = new CategoryRepositoryImpl();
    }
    @Override
    public List<Word> getWordsByCategoryName(String categoryName) throws FileNotFoundException {
        List<Word> words = new ArrayList<>();
        Scanner reader = new Scanner(new FileReader(FILE_NAME));
        StringBuilder sb = new StringBuilder();

        while(reader.hasNext()) {
            String line = reader.nextLine();
            if(line.toLowerCase().substring(1).equals(categoryName.toLowerCase())){
                while(true){
                    Word word = new Word(reader.nextLine());
                    if(word.getName().startsWith("_") || !reader.hasNext()){
                        break;
                    } else {
                        words.add(word);
                    }
                }
            }

        }
        reader.close();

        return words;
    }
}
