package conway;

import java.util.LinkedList;
import java.awt.Point;

public class GrilleSchelling extends Grille {
  /**
  *Classe GrilleSchelling heritant de la classe grille. Cette classe a un attribut prive : k.
  *k est un entier
  *@author Baptiste Guyot, Loic Falgairac, Gabriel Levy
  */

  private int k;

  GrilleSchelling(int tailleGrille, int nbCouleurs, int k) {
    /**
    *Constructeur GrilleSchelling : prend en argument trois entiers : tailleGrille, nbCouleurs, k.
    *cree une grille
    *rempli les logements vacant
    */
    super(tailleGrille, nbCouleurs + 1); // nb de couleurs + vacants
    creerLogementsVacants(grille.length * grille.length * 1 / 4); // au moins la moitié de cases vacantes

    if (k < 0 || k > 8)
      throw new IllegalArgumentException("k doit etre positif et inférieur à 8");
    this.k = k;

  }

  private void creerLogementsVacants(int nbLogementsVacants) {
    /**
    *methode creerLogementsVacants : prend en arguments un entier nbLogementsVacants.
    *vide le slogements jusqu'a avoir suffisament de logements vacants.
    */
    // s'assure qu'il y a suffisament de logements vacants, s'il n'y en a pas assez
    // elle en rajoute
    int nbLogementsVacantsReel = 0; // on compte le nombre de logements vacants déja existants
    int i, j;

    for (i = 0; i < grille.length; i++) {
      for (j = 0; j < grille.length; j++) {
        if (grille[i][j] == 0)
          nbLogementsVacantsReel++;
      }
    }

    while (nbLogementsVacantsReel < nbLogementsVacants) {
      // on prend une case au hasard
      i = (int) (Math.random() * grille.length);
      j = (int) (Math.random() * grille.length);

      // sià vacante, on lui met une couleurs aléatoire
      if (grille[i][j] != 0) {
        grille[i][j] = 0;
        save[i][j] = 0;
        nbLogementsVacantsReel++;
      }
    }
  }

  private void demenage(int i, int j) {
    /**methode demenage : prend en argument deux entiers i et j.
    *cette fonction demenage une couleur dans une place vacante choisie au hasard.
    */
    // demenage une couleur dans une place vacante au hasard
    int couleur = grille[i][j];
    // on creer une liste de coordonnées des logements vacants
    LinkedList<Point> logementsVacant = new LinkedList<Point>();
    for (int k = 0; k < grille.length; k++) {
      for (int l = 0; l < grille.length; l++) {
        if (grilleSuivante[k][l] == 0)
          logementsVacant.add(new Point(k, l));
      }
    }

    // on prend un logement vacants au hasard
    int t = (int) (Math.random() * logementsVacant.size());
    Point newHome = logementsVacant.get(t);
    grilleSuivante[newHome.x][newHome.y] = couleur;
    grilleSuivante[i][j] = 0; // l'ancienne maison est maintenant libre
  }

  @Override
  public void next() { // on redéfinit next qui est différent du jeu de conway
    /**
    *methode next : c'est une reecriture.
    *permet a l'affichage graphique de bouger.
    */
    int nbVoisinsCouleurDiff = 0; // compteur du nombre de voisins à l'état supérieur
    int couleur; // etat de la case actuelle
    int caseVoisine; // valeur de la case voisine

    for (int i = 0; i < grille.length; i++) {
      for (int j = 0; j < grille.length; j++) { // on va parcourir notre grille et regarder les voisins de chaques
                                                // cases

        couleur = grille[i][j];

        if (couleur != 0) {
          caseVoisine = grille[(i - 1 + grille.length) % grille.length][(j - 1 + grille.length) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i) % grille.length][(j - 1 + grille.length) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i + 1) % grille.length][(j - 1 + grille.length) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i - 1 + grille.length) % grille.length][(j) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i + 1) % grille.length][(j) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i - 1 + grille.length) % grille.length][(j + 1) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i) % grille.length][(j + 1) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          caseVoisine = grille[(i + 1) % grille.length][(j + 1) % grille.length];
          if (caseVoisine != couleur && caseVoisine != 0)
            nbVoisinsCouleurDiff++;

          if (nbVoisinsCouleurDiff > k) {
            demenage(i, j);
          }

          else {
            grilleSuivante[i][j] = grille[i][j];
          }
        }

        nbVoisinsCouleurDiff = 0; // on remet le compteur à 0 pour la prochaine case

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
