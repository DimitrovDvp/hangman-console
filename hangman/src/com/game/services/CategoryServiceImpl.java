package com.game.services;

import com.game.entities.Category;
import com.game.entities.Word;
import com.game.repositories.CategoryRepository;
import com.game.repositories.CategoryRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl() throws FileNotFoundException {
        this.categoryRepository = new CategoryRepositoryImpl();
    }

    @Override
    public List<String> getAll() throws FileNotFoundException {
        List<Category> categoryList = categoryRepository.getCategories();
        List<String> categoryNames = new ArrayList<>();
        for (Category category: categoryList)
        {
            categoryNames.add(category.getName().substring(1));
        }

        return categoryNames;
    }

    @Override
    public String getCategory() throws FileNotFoundException {
        for (String category : this.getAll()) {
            System.out.println(category);
        }

        Scanner scan = new Scanner(System.in);
        String category = scan.nextLine();

        return category.toLowerCase();
    }
}
