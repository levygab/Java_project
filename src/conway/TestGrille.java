package conway;

public class TestGrille {
    public static void main(String[] args) {
        Grille grille = new GrilleConway(2);
        System.out.println(grille.toString());
        System.out.println(grille.saveToString());
        grille.next();
        System.out.println(grille.toString());
        System.out.println(grille.saveToString());

    }
}
