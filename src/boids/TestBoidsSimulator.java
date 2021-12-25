package boids;

import gui.*;

import java.awt.Color;

public class TestBoidsSimulator {
    public static void main(String[] args) {

        GUISimulator gui = new GUISimulator(1000, 1000, Color.BLACK);

        Boids listeB = new Boids(50, gui.getPanelWidth(), gui.getPanelHeight());

        BoidsSimulator Bsim = new BoidsSimulator(listeB, gui);

        gui.setSimulable(Bsim);

    }
}
