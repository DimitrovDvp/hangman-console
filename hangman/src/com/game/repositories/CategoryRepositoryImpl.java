package com.game.repositories;

import com.game.entities.Category;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String FILE_NAME = "dictionary-data";
    private List<Category> categories;
    private int idCounter;

    public CategoryRepositoryImpl(){
        categories = new ArrayList<>();
    }

    @Override
    public List<Category> getAll() throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(FILE_NAME));
        StringBuilder sb = new StringBuilder();
        while(reader.hasNext()) {
            String line = reader.nextLine();
            if(line.startsWith("_")){
                this.add(line.substring(1));
            }
        }
        reader.close();

        return categories;
    }

    @Override
    public void add(String name) {
        Category category = new Category(nextId(),name);
        categories.add(category);
    }

    private int nextId(){
        return idCounter++;
    }
}
