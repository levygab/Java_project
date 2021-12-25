package conway;

public class GrilleImmigration extends Grille {

    GrilleImmigration(int tailleGrille, int nbEtats) {
        super(tailleGrille, nbEtats);

        for (int i = 0; i < tailleGrille; i++) { // on distribue aléatoirement l'état des cases
            for (int j = 0; j < tailleGrille; j++) {
                grille[i][j] = (int) (Math.random() * nbEtats); // met un nombre aléatoire entre 0 et nbEtats
                save[i][j] = grille[i][j];
            }
        }
    }

    GrilleImmigration(int[][] grille, int nbEtats) {
        super(grille, nbEtats);
    }

    @Override
    public void next() { // on redéfinit next qui est différent du jeu de conway

        int nbVoisinsEtatSup = 0; // compteur du nombre de voisins à l'état supérieur
        int etat; // etat de la case actuelle
        int etatSup; // etat inferieur à la case actuelle

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) { // on va parcourir notre grille et regarder les voisins de chaques
                                                      // cases

                etat = grille[i][j];
                etatSup = (etat + 1) % nbEtats;

                if (grille[(i - 1 + grille.length) % grille.length][(j - 1 + grille.length) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i) % grille.length][(j - 1 + grille.length) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i + 1) % grille.length][(j - 1 + grille.length) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i - 1 + grille.length) % grille.length][(j) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i + 1) % grille.length][(j) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i - 1 + grille.length) % grille.length][(j + 1) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i) % grille.length][(j + 1) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (grille[(i + 1) % grille.length][(j + 1) % grille.length] == etatSup)
                    nbVoisinsEtatSup++;

                if (nbVoisinsEtatSup >= 3) {
                    grilleSuivante[i][j] = etatSup;
                }

                else {
                    grilleSuivante[i][j] = etat;
                }

                nbVoisinsEtatSup = 0; // on remet le compteur à 0 pour la prochaine case

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
