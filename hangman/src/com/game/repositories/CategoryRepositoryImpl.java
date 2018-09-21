package com.game.repositories;

import com.game.entities.Category;
import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryRepositoryImpl implements CategoryRepository {

    private List<Category> categories;

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

    /*TODO*/
    @Override
    public Category findCategoryByName(String name) throws FileNotFoundException {
        for (Category category : this.getAll()) {
            System.out.println(category.getName().substring(1) + " == " + name);
            if (category.getName().substring(1).equals(name)){
                return category;
            }
        }

        return null;
    }
}
