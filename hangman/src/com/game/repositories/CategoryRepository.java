package com.game.repositories;

import com.game.entities.Category;

import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryRepository extends BaseRepository {
    List<Category> initCategories() throws FileNotFoundException;

    List<Category> getCategories();

    void add(String name);
}
