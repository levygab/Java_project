package conway;

public class GrilleConway extends Grille {
  /**
  *Classe GrilleConway qui herite de la classe Grille.
  *@author equipe 56
  */

  GrilleConway(int tailleGrille) {
    /**
    *constructeur GrilleConway prenant en argument un entier tailleGrille.
    *construit une grille de taille taille grille avec 2 etats.
    */
    super(tailleGrille, 2);
  }

  GrilleConway(int[][] grille) {
    /**
    *constructeur GrilleConway prenant en argument un tableau d'entier grille.
    *construit une grille a partir de grille et avec 2 etats.
    */
    super(grille, 2);
  }

  @Override
  public void next() {
    /**
    *methode next. C'est une reecriture.
    permet a l'affichage graphique de bouger.
    *permet a l'affichage graphique de bouger.
    */

    int nbVoisinsVivants = 0;
    // on va parcourir notre grille pour compter le nombres de voisins
    // vivants de chaque case. On remplit alors notre gtrille suivante
    // en fonction des résultats
    for (int i = 0; i < grille.length; i++) {
      for (int j = 0; j < grille.length; j++) {

        // on compte le nombre de voisins vivants
        nbVoisinsVivants = grille[(i - 1 + grille.length) % grille.length][(j - 1 + grille.length) % grille.length] +

            grille[(i) % grille.length][(j - 1 + grille.length) % grille.length] +

            grille[(i + 1) % grille.length][(j - 1 + grille.length) % grille.length] +

            grille[(i - 1 + grille.length) % grille.length][(j) % grille.length] +

            grille[(i + 1) % grille.length][(j) % grille.length] +

            grille[(i - 1 + grille.length) % grille.length][(j + 1) % grille.length] +

            grille[(i) % grille.length][(j + 1) % grille.length] +

            grille[(i + 1) % grille.length][(j + 1) % grille.length];

        if (grille[i][j] == 1) { // cas ou la case est vivante

          if (nbVoisinsVivants == 2 || nbVoisinsVivants == 3)
            grilleSuivante[i][j] = 1; // elle reste vivante
          else
            grilleSuivante[i][j] = 0; // ici la case meurt
        }

        else {// cas ou la case est morte

          if (nbVoisinsVivants == 3)
            grilleSuivante[i][j] = 1; // la case nait
          else
            grilleSuivante[i][j] = 0; // la case reste morte
        }

        nbVoisinsVivants = 0; // on remet le compteur à 0 pour la prochaine case

      }
    }

    for (int i = 0; i < grille.length; i++) { // pour finir, on copie notre nouvelle grille dans la grille qui
                                              // s'affiche
      for (int j = 0; j < grille.length; j++) {
        grille[i][j] = grilleSuivante[i][j];
      }
    }
  }

}
