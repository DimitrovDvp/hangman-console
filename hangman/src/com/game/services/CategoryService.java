package com.game.services;

import com.game.entities.Category;
import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryService {
    List<String> getAll() throws FileNotFoundException;
}
