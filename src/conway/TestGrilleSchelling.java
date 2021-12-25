package conway;

import gui.*;
import java.awt.Color;
import java.util.Scanner;

public class TestGrilleSchelling {
    public static void main(String[] args) {
      //Entrée des paramètres:

        System.out.println("Modèle de Schelling:");
        System.out.println("Quelle taille de grille? [300 max]");
        Scanner sc = new Scanner(System.in);
        int size, nbcoul, k;
        size = sc.nextInt();
        System.out.println("Combien de couleurs en plus des logements vacants? [8 max]");
        nbcoul = sc.nextInt();
        System.out.println("A partir de quel seuil la famille déménage? [8 max]");
        k = sc.nextInt();
        System.out.println("Lancement simulation");

        GUISimulator gui = new GUISimulator(500, 1000, Color.BLACK);

        Grille grille = new GrilleSchelling(size, nbcoul, k);

        gui.setSimulable(new GrilleSimulator(grille, gui));

    }
}
