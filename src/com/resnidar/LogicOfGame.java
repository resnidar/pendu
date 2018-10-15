package com.resnidar;

import java.io.IOException;
import java.util.Scanner;

public class LogicOfGame {
    public void logic() {
        display(1);
        display(2);
        char[] wordTab = wordPrepar();
        Game(wordTab);
    }

    public void display(int number) {

        if (number == 1) {
            System.out.println("Bienvenue dans le jeu du pendu ,je suppose que vous connaissez les régles alors commencons !");
        } else if (number == 2) {
            System.out.println("voulez vous lancé la partie ?");
        } else {
            System.out.println("erreur");
        }
    }

    public char[] wordPrepar() {
        String word = null;
        int wordlength = 0;
        try {
            word = InspectCSV.read();
        } catch (IOException e) {
            System.out.println("il y a un probleme dans la lecture du csv");
        }
        for (int i = 0; i < word.length(); i++) {
            wordlength = i + 1;
        }
        char wordTab[] = new char[wordlength];
        for (int i = 0; i < word.length(); i++) {
            wordTab[i] = word.charAt(i);
        }
        return wordTab;
    }

    public void Game(char[] wordTab) {
        Scanner sc = new Scanner(System.in);
        int wordLength;
        wordLength = 0;
        for (int i = 0; i < wordTab.length; i++) {
            wordLength = i + 1;
        }
        char underscoreTab[] = new char[wordLength];
        for (int i = 0; i < wordLength; i++)
        {
            underscoreTab[i] = '_';
        }
        /**
         * ici se trouve tout le systeme permettant de remplacé des underscores par le resultat
         */
        for (int i = 0; i < 7 ; i++){
            char inChar = sc.next().charAt(0);
            for(int j = 0; j < wordLength; j++){
                if (inChar == wordTab[j]) {
                    underscoreTab[j] = wordTab[j];
                }
            }
            for (int j = 0; j < wordLength ;j++){
                System.out.print(underscoreTab[j]);
                System.out.print(" ");
            }
        }
    }
}
