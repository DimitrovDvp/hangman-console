package com.game.services;

import com.game.entities.Category;
import com.game.entities.Word;
import com.game.repositories.CategoryRepository;
import com.game.repositories.CategoryRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
}
