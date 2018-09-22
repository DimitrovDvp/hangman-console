package com.game.repositories;

import com.game.entities.Category;
import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryRepositoryImpl implements CategoryRepository {

    public List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public CategoryRepositoryImpl() throws FileNotFoundException {
        categories = new ArrayList<>();
        this.initCategories();
    }

    @Override
    public List<Category> initCategories() throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(FILE_NAME));
        StringBuilder sb = new StringBuilder();
        while(reader.hasNext()) {
            String line = reader.nextLine();
            if(line.startsWith("_")){
                this.add(line);
            }
        }
        reader.close();

        return categories;
    }

    @Override
    public void add(String name) {
        Category category = new Category(name);
        categories.add(category);
    }
}
