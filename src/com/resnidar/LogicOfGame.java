package com.resnidar;

import java.io.IOException;

public class LogicOfGame {
    public void logic(){
        display(1);
        display(2);
        wordPrepar();
    }

    public void display(int number) {

        if (number == 1) {
            System.out.println("Bienvenue dans le jeu de pendu ,je suppose que vous connaissez les régles alors commencons !");
        }
        else if (number == 2) {
            System.out.println("voulez vous lancé la partie ?");
        }
        else
        {
            System.out.println("erreur");
        }
    }

    public void wordPrepar(){
        try {
            String word = InspectCSV.read();
            System.out.println(word);
        } catch (IOException e) {
            System.out.println("il y a un probleme dans la lecture du csv");
        }
    }
}
