/**
 * Title: Hangman.java
 * Abstract: Write a Java program called Hangman.java that reads a word (or a phrase) from a user and plays the hangman game.
 * Name: Pernille Dahl
 * Date: 2018-Sept-13
 **/

package Homework2;


import java.util.Scanner;

public class Hangman {

    private String word = "";
    private char[] characters;
    private boolean[] status;
    private int numGuessesLeft;

    private void startGame() {
        Scanner input = new Scanner( System.in );

        System.out.println( "---------- Welcome To Hangman ---------- \n" );
        System.out.print( "Enter a word: " );

        // pick a word
        while (true) {
            word = input.nextLine();
            if(isWordValid(word)){
                numGuessesLeft = word.length()/2;
                word = word.replaceAll( " ", "#" ); // space replaced by #
                characters = word.toCharArray();
                status = new boolean[word.length()];
                for(int i=0; i<characters.length; i++) if(characters[i] == '#') status[i] = true;
                printStatus();
                break;
            }
            System.out.print("Try again! - Enter a word: ");
        }


        while (numGuessesLeft > 0) {
            String hintOrGuess;
            String guessedChar;
            System.out.print( "Enter either 1 for guessing or 2 for hint: " );
            hintOrGuess = input.next();
            while (true) {
                if ( isOptionValid( hintOrGuess ) ) {
                    switch (hintOrGuess) {
                        case "1":
                            System.out.print( "Enter your guess: " );
                            guessedChar = input.next();
                            while (true) {
                                if ( isCharValid( guessedChar ) ) { // infinite loop
                                    guess( guessedChar.charAt( 0 ) );
                                    break;
                                }
                                System.out.print( "Enter your guess: " );
                            }
                            break;
                        case "2":
                            hint();
                            break;
                    }
                    break;
                }
            }
        }

    }

    private boolean isWordValid(String input) {
        if (!input.matches( "[A-Z].*" ) ) {
            System.out.println( "Incorrect input!" );
            return false;
        }
        return true;
    }

/// need to look over
    private boolean isCharValid(String input) {
        if (input.length() != 1 && !input.matches( "[A-Z].*" ) ) {
            System.out.println( "Incorrect input!" );
            return false;
        }
        return true;
    }

    private boolean isOptionValid(String input) {
        if ( input.length() != 1 && !input.matches( "[1-2]" ) ) {
            System.out.println( "Incorrect input!" );
            return false;
        }
        return true;
    }

    private void guess(char c) {
        boolean found = false;
        for (int i = 0; i < characters.length; i++) { // Null Pointer exception thrown here // debug program ends here
            if ( characters[i] == c ) {
                status[i] = true;
                found = true;
            }
        }
        if ( !found ) {
            numGuessesLeft--;
            System.out.printf( "Sorry! %s is not the word\n", c );
        }
        printStatus();
    }

    private void printStatus() {
        if ( numGuessesLeft == 0 ) {
            System.out.println( "Game Over! The word was " + word.toUpperCase());
            System.exit( 0 );
        }
        if(hasWon()){
            System.out.println("Congratulations! The word was " + word.toUpperCase() + "");
            System.exit( 0 );
        }
        System.out.print("So far, the word is: ");
        for (int i = 0; i < characters.length; i++) {
            if ( status[i] ) {
                System.out.print( characters[i] + " " );
            } else {
                System.out.print( " _ " );
            }
        }
        System.out.println( "\n number of guesses left: " + numGuessesLeft );
        System.out.println();
    }

    private boolean hasWon() {
        for (boolean b : status) {
            if(!b) return false;
        }
        return true;
    }

    private void hint() {
        for(int i = 0; i < status.length; i++){
            if(!status[i]){
                status[i] = true;
                System.out.println("OK! The hint is " + characters[i]);
                numGuessesLeft--;
                // this loop checks all the other chars equal the current hint and shows them
                for (int j = 0; j < characters.length; j++) {
                    if ( characters[j] == characters[i] ) {
                        status[j] = true;
                    }
                }
                printStatus();
                break;
            }
        }

    }

    public static void main(String[] args) {

        Hangman hangman = new Hangman();
        hangman.startGame();

    }
}

