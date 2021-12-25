package conway;

import gui.*;
import java.awt.Color;
import java.util.Scanner;

public class TestGrilleConway {
    public static void main(String[] args) {

        // Entrée des paramètres:
        System.out.println("Jeu de la vie de Conway:");
        System.out.println("Quelle taille de grille? [300 max]");
        Scanner sc = new Scanner(System.in);
        int size;
        size = sc.nextInt();

        GUISimulator gui = new GUISimulator(500, 1000, Color.BLACK);

        Grille grille = new GrilleConway(size);

        gui.setSimulable(new GrilleSimulator(grille, gui));

    }
}
