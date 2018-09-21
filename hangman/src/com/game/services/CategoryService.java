package com.game.services;

import com.game.entities.Category;
import com.game.entities.Word;

import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryService {
    void printAll() throws FileNotFoundException;
}
