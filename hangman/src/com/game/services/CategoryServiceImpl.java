package com.game.services;

import com.game.entities.Category;
import com.game.repositories.CategoryRepository;
import com.game.repositories.CategoryRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl() {
        this.categoryRepository = new CategoryRepositoryImpl();
    }

    @Override
    public void printAll() throws FileNotFoundException {
        List<Category> categoryList = categoryRepository.getAll();
        for (Category category: categoryList)
        {
            System.out.println(category.getId()+" "+category.getName());
        }
    }
}
