package com.resnidar;

import java.io.IOException;
import java.util.Scanner;

public class LogicOfGame {
    public void logic() {
        System.out.println("Bienvenue dans le jeu du pendu ,je suppose que vous connaissez" +
                " les regles alors commencons !");
        System.out.println("la partie commence");
        char[] wordTab = wordPrepar();
        Game(wordTab);
    }

    public char[] wordPrepar() {
        String word = null;
        int wordlength = 0;
        try {
            word = InspectCSV.read();
        } catch (IOException e) {
            System.out.println("il y a un probleme dans la lecture du csv,veuillez verifier que vous avez bien wordList.csv a la racine du jeu");
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
            System.out.println("veuillez entrer un caractere");
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
        System.out.println("la partie est terminé ,il manque encore quelque logique de jeu indispensable ,sa arrive !");
    }
}
