package boids;

import processing.core.*;

/**Classe Boid ayant 7 attributs privés:
position, vitesse, acceleration, rayon et angle de vision, vitesse et force maximums.
*Cette classe à 11 méthodes publiques et une méthode privée.
*@author equipe56
*/
public class Boid {
  private PVector position;
  private PVector vitesse;
  private PVector acceleration;
  private float rayonVision = 100;
  private float angleVision = 150; // en degre
  private float maxSpeed = 2;
  private float maxForce = 0.05f;

  Boid(int width, int height) {
    /** Constructeur de Boid.
    *@param positions maximales x et y
    *@return
    */
    this((float) (Math.random() * width), (float) (Math.random() * height), (float) (Math.random() * 5),
        (float) (Math.random() * 5));
  }

  Boid(float x, float y) {
    /** Constructeur de Boid.
    *@param position x et y
    *@return
    */
    position = new PVector(x, y);
    vitesse = new PVector();
    acceleration = new PVector();
  }

  Boid(float x, float y, float vx, float vy) {
    /** Constructeur de Boid.
    *@param position x et y, vitesse vx et vy
    *@return
    */
    this(x, y);
    vitesse.set(vx, vy);
  }

  Boid(PVector position, PVector vitesse, PVector acceleration, float rayonVision, float angleVision) {
    /** Constructeur de Boid.
    *@param position, vitesse, acceleration, rayon de vision, angle de vision
    *@return
    */
    this.position = position;
    this.vitesse = vitesse;
    this.acceleration = acceleration;
    this.rayonVision = rayonVision;
    this.angleVision = angleVision;
  }

  public void setRayonVision(float rayonVision) {
    /** Méthode pour mettre le rayon de vision.
    *@param rayon de vision
    *@return
    */
    this.rayonVision = rayonVision;
  }

  public boolean isNextTo(Boid boid) {
    /** Méthode pour repérer les voisins d'un boid.
    *@param boid
    *@return bool
    */
    // return true si le boid entrée est dans le champ de vision
    if (PVector.dist(position, boid.getPosition()) <= rayonVision) {
      float angle = PVector.angleBetween(this.vitesse, boid.position);
      if (Math.abs(angle * 360 / (2 * Math.PI)) < angleVision) {
        return true;
      }
    }
    return false;
  }

  public PVector getPosition() {
    /** Renvoie la position du boid.
    *@param
    *@return la position du boid
    */
    return position.copy();
  }

  public float getX() {
    /** Renvoie le paramètre x de la position du boid.
    *@param
    *@return position.x
    */
    return position.x;
  }

  public float getY() {
    /** Renvoie le paramètre y de la position du boid.
    *@param
    *@return position.y
    */
    return position.y;
  }

  public PVector getVitesse() {
    /** Renvoie la vitesse du boid.
    *@param
    *@return vitesse
    */
    return vitesse.copy();
  }

  public PVector getAcceleration() {
    /** Renvoie l'accélération du boid.
    *@param
    *@return position.x
    */
    return acceleration.copy();
  }

  public void setPosition(float x, float y) {
    /** Met à (x, y) la position du boid.
    *@param float x, float y
    *@return
    */
    position.set(x, y);
  }

  public void setVitesse(float vx, float vy) {
    /** Met à (vx, vy) la vitesse du boid.
    *@param float vx, float vy
    *@return
    */
    vitesse.set(vx, vy);
  }

  public Boid copy() {
    /** Renvoie une copie du boid.
    *@param
    *@return boid
    */
    return new Boid(position, vitesse, acceleration, angleVision, rayonVision);
  }

  public void update(PVector force, int width, int height) {
    /** Met à jour la vitesse, en faisant attention de ne rien percuter.
    *@param force, width, height
    *@return
    */
    force.limit(maxForce);
    vitesse.add(force);
    vitesse.limit(maxSpeed);
    position.add(vitesse);
    rebond(width, height);

  }

  private void rebond(int width, int height) {

    /** Fait rebondir le boid.
    *@param int width, int height
    *@return
    */
    if (position.x < 0 + 30) {
      vitesse.x = 1;
    }
    if (position.x > width - 30) {
      vitesse.x = -1;
    }
    if (position.y < 0 + 30) {
      vitesse.y = 1;
    }
    if (position.y > height - 30) {
      vitesse.y = -1;
    }
  }
}
