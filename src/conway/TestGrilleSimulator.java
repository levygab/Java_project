package conway;

import gui.*;
import java.awt.Color;

public class TestGrilleSimulator {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(500, 1000, Color.BLACK);

        /*A servi pour les teste*/

        Grille grille = new GrilleConway(200);

        gui.setSimulable(new GrilleSimulator(grille, gui));

    }
}
