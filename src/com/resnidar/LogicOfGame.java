package com.resnidar;

import java.io.IOException;
import java.util.Scanner;

public class LogicOfGame {
    public void logic() {
        System.out.println("Bienvenue dans le jeu du pendu ,je suppose que vous connaissez les regles alors commencons !");
        System.out.println("la partie commence");
        char[] wordTab = wordPrepar();
        Game(wordTab);
    }

    public char[] wordPrepar() {
        String word = null;
        int wordlength = 0;
        try {
            word = InspectCSV.read();
            for (int i = 0; i < word.length(); i++) {
                wordlength = i + 1;
            }
            char wordTab[] = new char[wordlength];
            for (int i = 0; i < word.length(); i++) {
                wordTab[i] = word.charAt(i);
            }
            return wordTab;
        } catch (IOException e) {
            System.out.println("il y a un probleme dans la lecture du csv,veuillez verifier que vous avez bien wordList.csv a la racine du jeu");
            System.exit(1);
        }
        return null;
    }

    public void Game(char[] wordTab) {
        Scanner sc = new Scanner(System.in);
        int wordLength = 0;
        for (int i = 0; i < wordTab.length; i++) {
            wordLength = i + 1;
        }
        char underscoreTab[] = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            underscoreTab[i] = '_';
        }
        printUndescore(wordLength, underscoreTab);
        /**
         * ici se trouve tout le systeme permettant de remplacé des underscores par le resultat
         */
        for (int i = 0; i < 7; i++) {
            System.out.println("veuillez entrer un caractere");
            char inChar = sc.next().charAt(0);
            for (int j = 0; j < wordLength; j++) {
                if (inChar == wordTab[j]) {
                    underscoreTab[j] = wordTab[j];
                }
            }
            printUndescore(wordLength, underscoreTab);
        }
        endGame(sc, wordLength, underscoreTab);
    }

    /**
     * vérification a chaque fin de tour ,si il reste des underscore ont continue ,sinon fin de la partie
     */
    public void endGame(Scanner sc, int wordLength, char[] underscoreTab) {
        int counter = 0;
        for (int j = 0; j < wordLength; j++) {
            if (underscoreTab[j] == '_')
                counter++;
        }
        if (counter == 0) {
            System.out.println("vous avez gagner ! la partie va se relancé");
            System.out.println("voulez vous relancé la partie ? et regagné ! \r\ny : pour relancé \r\nn'importe quel touches pour quitter");
            char restart = sc.next().charAt(0);
            if (restart == 'y')
                this.logic();
            else
                System.out.println("fin de la partie ,le programme se quitte");
        } else {
            System.out.println("vous avez perdu ,voulez vous recommencé ?" + "\r\ny : recommencer" + "\r\nn'importe quel touche pour quitter");
            char restart = sc.next().charAt(0);
            if (restart == 'y')
                this.logic();
            else
                System.out.println("fin de la partie ,le programme se quitte");
        }
    }

    public void printUndescore(int wordLength, char[] underscoreTab) {
        for (int j = 0; j < wordLength; j++) {
            System.out.print(underscoreTab[j]);
            System.out.print(" ");
        }
    }
}