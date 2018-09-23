package com.game.views;

import com.game.entities.Word;
import com.game.services.CategoryService;
import com.game.services.CategoryServiceImpl;
import com.game.services.WordService;
import com.game.services.WordServiceImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class GameView {
    private final CategoryService categoryService;

    private final WordService wordService;

    public GameView() throws FileNotFoundException {
        this.categoryService = new CategoryServiceImpl();
        this.wordService = new WordServiceImpl();
    }

    public void startGame() throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        int playerScore = 0;
        int attempts = 10;

        while(true){
            String category = categoryService.getCategory();
            Word word = wordService.getRandomWord(category);
            if (word == null){
                System.out.println("There is no such category \n");
                continue;
            }

            String currentProgressWord = wordService.hideWord(word);
            while(attempts > 0){
                if(!this.wordService.isGameFinished(currentProgressWord)){
                    System.out.println("Attempts left: " + attempts);
                    System.out.println("Current word/phrase:  " + currentProgressWord);
                    System.out.println("Please enter a letter:");

                    char letterGuess = scan.next().charAt(0);
                    if(Character.isLetter(letterGuess)){
                        List<Integer> letterPositions = wordService.guessLetter(letterGuess, word);
                        if (letterPositions.size() == 0){
                            attempts--;
                            System.out.println("The word/phrase doesn’t have this letter.\n");
                        } else {
                            currentProgressWord = this.wordService
                                    .revealLetters(letterGuess, letterPositions, currentProgressWord);
                        }
                    } else {
                        System.out.println("\nUse only letters");
                        continue;
                    }
                } else if (this.wordService.isGameFinished(currentProgressWord) && attempts > 0){
                    playerScore++;
                    attempts = 10;
                    System.out.println("Congratulations you have revealed the word/phrase: " + currentProgressWord);
                    System.out.println("Current score: " + playerScore);
                    break;
                }
            }
        }
    }
}
