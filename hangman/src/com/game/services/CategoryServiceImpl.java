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

    public CategoryServiceImpl() {
        this.categoryRepository = new CategoryRepositoryImpl();
    }

    @Override
    public void getAll() throws FileNotFoundException {
        List<Category> categoryList = categoryRepository.getAll();
        List<String> categoryNames = new ArrayList<>();

        for (Category category: categoryList)
        {
            categoryNames.add(category.getName().substring(1));
        }
    }
}
