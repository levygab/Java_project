package boids;

import java.util.LinkedList;

import processing.core.PVector;

public class Boids {
  private LinkedList<Boid> groupeBoids;
  private LinkedList<Boid> newGroupeBoids;
  private LinkedList<Boid> save;

  Boids(int nbBoid, int width, int height) {
    // ajoute nbBoid avec des positions aléatoires
    // width et height: positions max x et y
    groupeBoids = new LinkedList<Boid>();
    newGroupeBoids = new LinkedList<Boid>();
    save = new LinkedList<Boid>();
    for (int i = 0; i < nbBoid; i++) {
      groupeBoids.add(new Boid(width, height));
      newGroupeBoids.add(groupeBoids.get(i).copy());
      save.add(groupeBoids.get(i).copy());
    }
  }

  public void update(int width, int height) {
    Boid newBoid;
    PVector force = new PVector(0, 0);
    int i = 0;
    for (Boid boid : groupeBoids) {
      newBoid = boid.copy();
      force.add(rule1(boid));
      force.add(rule2(boid));
      force.add(rule3(boid));
      newBoid.update(force.div(7), width, height);
      newGroupeBoids.set(i, newBoid);
      i++;
    }
    i = 0;
    for (Boid boid : newGroupeBoids) {
      groupeBoids.set(i, boid.copy());
      i++;
    }
  }

  public void restart() {
    groupeBoids.clear();
    for (int i = 0; i < save.size(); i++) {
      groupeBoids.add(save.get(i).copy());
    }
  }

  private PVector rule1(Boid boid) {
    // Boids try to fly towards the centre of mass of neighbouring boids
    PVector gravityCenter = new PVector(0, 0);
    PVector resultat = new PVector(0, 0);
    int nbVoisins = 0;
    for (Boid otherBoid : groupeBoids) {
      if (boid.isNextTo(otherBoid)) {
        if (boid != otherBoid) {
          gravityCenter.add(otherBoid.getPosition());
          nbVoisins++;
        }
      }
    }
    if (nbVoisins == 0) {
      return resultat;
    }
    gravityCenter.div(nbVoisins);
    resultat = gravityCenter.sub(boid.getPosition());
    resultat.div(100);
    return resultat;
  }

  private PVector rule2(Boid boid) {
    // Boids try to keep a small distance away from other objects (including other
    // boids)
    PVector resultat = new PVector(0, 0);
    PVector positon;
    PVector otherPosition;
    for (Boid otherBoid : groupeBoids) {
      positon = new PVector(boid.getY(), boid.getX());
      otherPosition = new PVector(otherBoid.getX(), otherBoid.getY());
      if (positon.dist(otherPosition) < 100) {
        resultat.sub(positon.sub(otherPosition));
      }
    }
    return resultat;
  }

  private PVector rule3(Boid boid) {
    // Boids try to match velocity with near boids
    PVector vitesseMoyenne = new PVector(0, 0);
    PVector resultat = new PVector(0, 0);
    int nbVoisins = 0;
    for (Boid otherBoid : groupeBoids) {
      if (boid.isNextTo(otherBoid)) {
        if (boid != otherBoid) {
          vitesseMoyenne.add(otherBoid.getVitesse());
          nbVoisins++;
        }
      }
    }
    if (nbVoisins == 0) {
      return resultat;
    }
    vitesseMoyenne.div(nbVoisins);
    resultat = vitesseMoyenne.sub(boid.getVitesse());
    resultat.div(8);
    return resultat;
  }

  public Boid get(int index) {
    return groupeBoids.get(index);
  }

  public LinkedList<Boid> getBoids() {
    return groupeBoids;
  }
}
