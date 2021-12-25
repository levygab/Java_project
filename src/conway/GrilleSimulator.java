package conway;

import java.awt.Color;

import gui.*;

public class GrilleSimulator implements Simulable {
  /**
  *classe GrilleSimulator implementant la classe Simulable.
  *cette classe a trois attributs prives : grille, gui et grilleGraphique.
  *grille est une grille.
  *gui ets un GUISimulator
  *grilleGraphique est un tableau 2D de Rectangle
  *@author Baptiste Guyot, Loic Falgairac, Gabriel Levy
  */

  private Grille grille;
  private GUISimulator gui;
  private Rectangle[][] grilleGraphique;

  GrilleSimulator(Grille grille, GUISimulator gui) {
    /**
    *constructeur GrilleSimulator : prend en argument une Grille grille et un GUISimulator gui.
    */
    this.grille = grille;
    this.gui = gui;

    grilleGraphique = new Rectangle[grille.size()][grille.size()];

    afficheGrille();
  }

  @Override
  public void next() {
    /**
    *methode next necessaire a l'implementation de Simulable.
    *Permet a l'affiche graphique de bouger
    */
    grille.next(); // on effectue les changements dans la grille

    afficheGrille(); // on reaffiche la grille qui a été mise a jour
  }

  @Override
  public void restart() {
    /**
    *methode restart necessaire a l'implementation de Simulable
    *remet la grille a sa valeur d'origine.
    */
    grille.restart();
    afficheGrille();
  }

  private void afficheGrille() { // gère l'affichage de la grille
    /**
    *methode afficheGrille
    *Cette methode gere l'affichage de la grille
    */
    Color color;
    int size = gui.getPanelHeight() / grille.size(); // on calcule la taille d'une case

    gui.reset(); // permet de supprimer la grille précédente afin de ne pas surcharger
    // l'affichage

    for (int i = 0; i < grille.size(); i++) {
      for (int j = 0; j < grille.size(); j++) {

        color = new Color(0, 0, 255 * grille.get(i, j) / (grille.getNbEtats() - 1));
        //Pour nos simulations, on aura besoin de au maximum 8 couleurs en comptant le noir:

        if (grille.get(i, j) == 0)
        color = Color.BLACK;
        if (grille.get(i, j) == 1)
        color = Color.RED;
        if (grille.get(i, j) == 2)
        color = Color.GREEN;
        if (grille.get(i, j) == 3)
        color = Color.BLUE;
        if (grille.get(i, j) == 4)
        color = Color.PINK;
        if (grille.get(i, j) == 5)
        color = Color.GRAY;
        if (grille.get(i, j) == 6)
        color = Color.WHITE;
        if (grille.get(i, j) == 7)
        color = Color.CYAN;
        if (grille.get(i, j) == 8)
        color = Color.YELLOW;

        grilleGraphique[i][j] = new Rectangle(size * i + size / 2, size * j + size / 2, Color.black, color,
        size); // on créer nos rectangles graphiques
        gui.addGraphicalElement(grilleGraphique[i][j]); // on les ajoute sur le simulateur
      }
    }
  }

  }
