package com.game;

import com.game.entities.Word;
import com.game.services.WordService;
import com.game.services.WordServiceImpl;
import com.game.views.GameView;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] arBgs) throws FileNotFoundException {
        GameView game = new GameView();
        game.startGame();
    }

}
