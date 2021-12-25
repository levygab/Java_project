import gui.*;
import java.awt.Color;
import java.util.LinkedList;


public class BallsSimulator implements Simulable{
  /**
  *Classe BallsSimulator implementant Simulable. Cette classe a 7 attributs prives : balls, compteur, ballAffichage, gui, vx, vy, taille_simu
  *balls est un Balls.
  *compteur, vx, vy et taille_simu sont des int.
  *ballsAffichage est une liste d'oval.
  *gui est un GUISimulator.

  *@author Baptiste Guyot, Loic Falgairac, Gabriel Levy
  */
  private Balls balls;
  private int compteur=0;
  private LinkedList<Oval> ballsAffichage;
  private GUISimulator gui;
  //Pour translater les boules:
  private int vx = 10;
  private int vy = 5;
  private int taille_simu = 500;

  public BallsSimulator() {
    /**
    *constructeur BallsSimulator.
    *cree et remplit balls de points ayant pour coordonnees (0,0).
    *cree et remplit ballsAffichage d'oval ayant pour coordonnees (0,0).
    */
    //Ajout ensemble de balls:
    balls = new Balls(); //la liste des boules : une liste de de points
    ballsAffichage = new LinkedList<Oval>(); //la liste qu'on affiche : une liste d'oval
    for (int i = 0; i < balls.size(); i++) {
      // on ajoute a la liste d'affichage tous le spoints de balls.
      ballsAffichage.add()
      //new Oval(balls.get(i).x, balls.get(i).y, Color.decode("#1f77b4"), Color.decode("#1f77b4"), 10) );
    }

  }

  public BallsSimulator(Balls balls, GUISimulator gui,int size)) {
    /**
    *constructeur BallsSimulator prenant en argument un Balls balls et un GUISimulator gui.
    *cree et remplit ballsAffichage d'oval ayant pour coordonnees les points dans balls
    */
    //constructeur qui prend en arguments une balls et un GUI
    this.balls = balls;
    this.gui = gui;
    this.taille_simu = size;
    ballsAffichage = new LinkedList<Oval>();
    //Affichage des balls:
    for (int i = 0; i < balls.size(); i++){
      ballsAffichage.add(new Oval(balls.get(i).x, balls.get(i).y, Color.decode("#1f77b4"), Color.decode("#1f77b4"), 10));
      gui.addGraphicalElement(ballsAffichage.get(i));


    }
  }

  //Dans le programme suivant l'utilisation de %1000 permet de se concentrer sur un seul cycle
  //A la fin du cycle vx et vy, on fait comme si la boule en recommençait un nouveau.
  @Override
  public void next(){
    /**
    *methode next necessaire car on implemente Simulable.
    *deplace les points a la prochaine etape et les translatant de vx et vy.
    *S'ils atteignent un mur, ils rebondissent dessus.
    */
    compteur ++;
    //on deplace chaque boule une a une
    for (int j = 0; j < ballsAffichage.size(); j++){

      //on regarde si la boule a atteint un mur
      if((balls.getStockX(j) + compteur * vx) % (2 * taille_simu) < taille_simu){
        //elle n'a pas atteint le mur des x

        if((balls.getStockY(j) + compteur * vy) % (2 * taille_simu) < taille_simu){
          //elle n'a pas atteint le mur des y donc elle n'a rencontre aucun mur
          balls.get(j).translate(vx, vy); //donc on la translate
          ballsAffichage.get(j).translate(vx,vy);  //on translate aussi celle qu'on affiche
          //La boule a rencontré le mur y.
        }
        else {

          balls.get(j).translate(vx, -vy);
          ballsAffichage.get(j).translate(vx,-vy);

        }
      }


      if((balls.getStockX(j) + compteur * vx) % (2 * taille_simu) >= taille_simu){
        
        if((balls.getStockY(j) + compteur * vy) % (2 * taille_simu) < taille_simu){
          //La boule n'a rencontré que le mur x.
          balls.get(j).translate(-vx, vy);
          ballsAffichage.get(j).translate(-vx,vy);
        }
        else {
          //La boule a rencontré les 2 murs. (elle fait marche arrière)
          balls.get(j).translate(-vx, -vy);
          ballsAffichage.get(j).translate(-vx,-vy);

        }
      }
    }
}

@Override
public void restart(){
  /**
  *methode restart necessaire car on implement Simulable.
  *remet tous les points a leurs coordonnees de depart.
  */

  for (int i = 0; i < ballsAffichage.size(); i++){
    ballsAffichage.get(i).translate(balls.getStockX(i) - balls.getX(i), balls.getStockY(i) - balls.getY(i));
  }
  balls.reInit();


}

}
