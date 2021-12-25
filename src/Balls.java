
import java.awt.*;
import java.util.*;

public class Balls {

  /**
  *Classe Balls ayant deux attributs prives : boules et stock.
  *boules et stock sont des listes de points.

  *@author equipe 56
  */


  private LinkedList<Point> boules;
  private LinkedList<Point> stock;

  // Constructeur:
  public Balls() {
    /**
    *Constructeur Balls : cree les listes vides de boules et stocks.
    */

    boules = new LinkedList<Point>();
    stock = new LinkedList<Point>();
  }

  public void add(Point P)
    /**
    *methode add prenant en argument un point P.
    *Ajoute P a boules.
    *Ajoute une copie de P a stock.
    */
    boules.add(P);
    stock.add(new Point(P));
  }

  public void add(int x, int y) {
  /**
   *methode add prenant en argument deux entiers : x et y.
   *cree deux points de coordonnees x et y qui sont respectivement ajoutes a boules et stock.
   */

    boules.add(new Point(x, y));
    stock.add(new Point(x, y));
  }

  public int getStockX(int i) {
    /**
    *methode getStockX : prend en argument un entier i.
    *Renvoie la coordonnees x du point numero i dans la liste stock.
    */
    return stock.get(i).x;
  }

  public int getStockY(int i) {
    /**
    *methode getStockY : prend en argument un entier i.
    *Renvoie la coordonnees Y du point numero i dans la liste stock.
    */
    return stock.get(i).y;
  }

  public int getX(int i) {
    /**
    *methode getX : prend en argument un entier i.
    *Renvoie la coordonnees x du point numero i dans la liste boules.
    */
    return boules.get(i).x;
  }

  public int getY(int i) {
    /**
    *methode getY : prend en argument un entier i.
    *Renvoie la coordonnees Y du point numero i dans la liste boules.
    */
    return boules.get(i).y;
  }

  public void reInit() {
    /**
    *methode reInit.
    *Remet toutes les boules de la liste boules a leur coordonnees initiale qui sont les coordonees dans la liste stock.
    */
    int i = 0;
    for (Point P : boules) {
      P.x = (int) stock.get(i).getX();
      P.y = (int) stock.get(i).getY();
      i++;
    }
  }

  public void translate(int dx, int dy) {
    /**
    *methode translate prenant en argument deux entiers : dx et dy.
    *Deplace tous les points de la liste boules de dx sur l'axe des x et de dy sur l'axe des y
    */
    for (Point P : boules) {
      P.translate(dx, dy);
    }
  }

  public int size() {
    /**
    *methode size
    *renvoie le nombre d'elements contenue dans les listes. Les deux listes ont le meme nombres d'elements.
    */
    return boules.size();
  }

  public Point get(int i) {
    /**
    *methode get prenant en argument un entier i.
    *renvoie le Point numero i de la liste boules
    */
    return boules.get(i);
  }

  @Override
  public String toString() {
    int i = 0;
    String res = "";
    for (Point P : boules) {
      res += "La balle " + i + "a pour coord" + P.toString() + "\n";
    }
    return res;
  }
}
