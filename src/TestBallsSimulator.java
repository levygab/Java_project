import java.awt.Color;

import gui.GUISimulator;

public class TestBallsSimulator {

    public static void main(String[] args) {
        // grille de 500 x 500:
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);

        Balls balls = new Balls();
        balls.add((int) (Math.random() * 500), (int) (Math.random() * 500));
        balls.add((int) (Math.random() * 500), (int) (Math.random() * 500));
        balls.add((int) (Math.random() * 500), (int) (Math.random() * 500));

        gui.setSimulable(new BallsSimulator(balls, gui, 500));

    }

}
