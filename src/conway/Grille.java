package conway;

public abstract class Grille {
  /**
  *Classe Grille ayant 4 attributs protected : grille, grilleSuivante, save et nbEtats
  *grille, grilleSuivante et save sont des tableaux 2D d'entiers.
  *nbEtats est un entier
  */
  protected int[][] grille; // true = vivant false = mort
  protected int[][] grilleSuivante;
  protected int[][] save;
  protected int nbEtats;

  Grille(int tailleGrille, int nbEtats) {
    /**
    *constructeur Grille prenant deux arguments : tailleGrille et nbEtats.
    *tailleGrille et nbEtats sont des entiers.
    *rempli grille de nombre aletoire entre 0 et nbEtats
    */
    // taille >0 et nb etats >0
    if (tailleGrille < 0) {
      throw new IllegalArgumentException("Taille négative!");
    }
    if (nbEtats < 1 || nbEtats > 8) {
      throw new IllegalArgumentException("Nombre d'états incorrect!");
    }
    grille = new int[tailleGrille][tailleGrille];
    save = new int[tailleGrille][tailleGrille];
    grilleSuivante = new int[tailleGrille][tailleGrille];
    this.nbEtats = nbEtats;

    for (int i = 0; i < tailleGrille; i++) { // on distribue aléatoirement l'état des cases
      for (int j = 0; j < tailleGrille; j++) {
        grille[i][j] = (int) (Math.random() * nbEtats); // met un nombre aléatoire entre 0 et nbEtats
        save[i][j] = grille[i][j];
      }
    }
  }

  Grille(int[][] grille, int nbEtats) {
    /**
    *Constructeur Grille prenant deux arguments : grille et nbEtats.
    *grille est un tableau d'entier
    *nbEtats est un entier.
    */
    if (grille.length != grille[0].length)
    throw new IllegalArgumentException("il faut une grille carrée!! \n");

    this.grille = grille;
    this.grilleSuivante = new int[grille.length][grille.length];
    this.save = new int[grille.length][grille.length];
    this.nbEtats = nbEtats;

    for (int i = 0; i < grille.length; i++) { // on copie la liste dans save
      for (int j = 0; j < grille.length; j++) {
        save[i][j] = grille[i][j];
      }
    }
  }

  public int size() {
    /**
    *methode size.
    *renvoie la taille de grille : le nombre d'elements du tableau.
    */
    return grille.length;
  }

  public int get(int i, int j) {
    /**
    *methode get prenant 2 arguments : 2 entiers : i et j.
    renvoie l'entier a la position (i,j) dans la grille.
    */
    return grille[i][j];
  }

  public int getNbEtats() {
    /**
    *methode getNbEtats.
    renvoie nbEtats.
    */
    return nbEtats;
  }

  public void setNbEtats(int nbEtats) {
    /**
    *methode setNbEtats prenant en argument un entier : nbEtats.
    *modifie this.nbEtats.
    */
    this.nbEtats = nbEtats;
  }

  public abstract void next();

  public void restart() {
    /**
    *methode restart.
    *remet toutes les valeurs de grille a leur valeur d'origine.
    */
    for (int i = 0; i < grille.length; i++) {
      for (int j = 0; j < grille.length; j++) {
        grille[i][j] = save[i][j];
      }
    }
  }

  public String saveToString() {
    /**
    *methode saveToString : renvoie un string contenant toutes les valeurs de save.
    */
    String res = "";
    for (int i = 0; i < save.length; i++) {
      for (int j = 0; j < save.length; j++) {
        res += save[i][j] + ",";
      }
      res += "\n";
    }
    return res;
  }

  @Override
  public String toString() {
    /**
    *methode toString : renvoie un string contenant toutes les valeurs de grille.
    */
    String res = "";
    for (int i = 0; i < grille.length; i++) {
      for (int j = 0; j < grille.length; j++) {
        res += grille[i][j] + ",";
      }
      res += "\n";
    }
    return res;
  }
}
