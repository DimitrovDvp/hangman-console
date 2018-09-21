package com.game.repositories;

import com.game.entities.Category;

import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryRepository extends BaseRepository {
    List<Category> getAll() throws FileNotFoundException;

    void add(String name);

    Category findCategoryByName(String name) throws FileNotFoundException;


}
