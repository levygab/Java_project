package conway;

import gui.*;
import java.awt.Color;
import java.util.Scanner;

public class TestGrilleImmigration {
    public static void main(String[] args) {

        //Entrée des paramètres:
        System.out.println("Jeu de l'immigration:");
        System.out.println("Quelle taille de grille? [300 max]");
        Scanner sc = new Scanner(System.in);
        int size, k;
        size = sc.nextInt();
        System.out.println("Combien de couleurs? [8 max]");
        k = sc.nextInt();
        System.out.println("Lancement simulation");

        GUISimulator gui = new GUISimulator(500, 1000, Color.BLACK);

        Grille grille = new GrilleImmigration(size, k);

        gui.setSimulable(new GrilleSimulator(grille, gui));

    }
}
