package boids;

import java.util.LinkedList;

import java.awt.*;

import gui.*;

public class BoidsSimulator implements Simulable {
  private Boids boids;
  private GUISimulator gui;
  private LinkedList<Oval> affichageBoids;

  BoidsSimulator(Boids boids, GUISimulator gui) {
    this.boids = boids;
    this.gui = gui;
    affichageBoids = new LinkedList<Oval>();
    setWindow();
  }

  private void setWindow() {
    // dessine les boids
    // Graphics2D triangle;
    // ImageElement boidGraphique;
    gui.reset();
    for (Boid boid : boids.getBoids()) {
      // triangle.drawPolygon(1, 2, 3);

      // boidGraphique.paint(triangle);

      affichageBoids.add(new Oval((int) boid.getX(), (int) boid.getY(), Color.BLUE, Color.BLUE, 10));
      gui.addGraphicalElement(affichageBoids.getLast());
    }

    gui.addGraphicalElement(new gui.Rectangle(500, 500, Color.RED, null, gui.getPanelWidth(), gui.getPanelHeight()));
  }

  public void next() {
    boids.update(gui.getPanelWidth(), gui.getPanelHeight());

    setWindow();
  }

  public void restart() {
    boids.restart();
    setWindow();
  }
}
