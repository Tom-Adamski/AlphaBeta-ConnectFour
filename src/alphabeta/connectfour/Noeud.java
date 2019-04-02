package alphabeta.connectfour;

public class Noeud {

    private int[][] matrice;
    /* la grille de l'état courant du jeu*/

    private boolean max;
    /* le type du joueur (true -> max -> machine) (false->min->l'humain)*/

    private int noColonne;
    /* le coup joué : numéro de colonne joué*/

    private int h;

    /* évaluation heuritique de noeud*/


    public Noeud(Boolean max, int[][] matrice) {

        this.max = max;
        this.matrice = matrice;

    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matriceJeu) {
        this.matrice = matriceJeu;
    }

    public boolean isMax() {
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public int getNoColonne() {
        return noColonne;
    }

    public void setNoColonne(int noColonne) {
        this.noColonne = noColonne;
    }

    @Override
    public String toString() {
        System.out.println("Coup joué" + noColonne);
        System.out.println("Evaluation h = " + h);
        String retour = "";
        for (int i = 0; i < matrice.length; i++) {
            retour += "\n";
            for (int j = 0; j < 5; j++) {
                retour += matrice[i][j] + "|";
            }
        }
        retour += "\n------------\n";
        return retour;
    }

    /**
     * fonction d'évaluation
     */
    public void evaluer() {

        int valeur = -troisPionsPossiblesLigne(false);
        valeur += troisPionsPossiblesLigne(true);
        valeur += -troisPionsPossiblesColonne(false);
        valeur += troisPionsPossiblesColonne(true);

        int ligne = -troisPionsAlignesLigne(false);
        ligne += troisPionsAlignesLigne(true);
        ligne += -troisPionsAlignesColonne(false);
        ligne += troisPionsAlignesColonne(true);

        valeur += ligne;

        h = valeur;

    }

    /**
     * calcule si 3 pions sont alignes en ligne
     *
     * @param typeJour type du joueur dont il faut verifier s'il a trois pions
     * alignes dans une ligne
     * @return 0 si pas d'alignement, 1000 si trois pions sont alignes
	 *
     */
    public int troisPionsAlignesLigne(Boolean typeJoueur) {
        String subs = "";
        if (typeJoueur) {
            subs = "111";
        } else {
            subs = "222";
        }

        for (int i = 0; i < matrice.length; i++) {
            String ligne = "";
            for (int j = 0; j < matrice[i].length; j++) {
                ligne += matrice[i][j];
            }
            if (ligne.contains(subs)) {
                return 1000;
            }
        }

        return 0;
    }

    /**
     * calcule si 3 pions sont alignes en colonne
	 *
     */
    public int troisPionsAlignesColonne(Boolean typeJoueur) {
        String subs = "";
        if (typeJoueur) {
            subs = "111";
        } else {
            subs = "222";
        }

        for (int i = 0; i < matrice.length; i++) {
            String ligne = "";
            for (int j = 0; j < matrice[i].length; j++) {
                ligne += matrice[j][i];
            }
            if (ligne.contains(subs)) {
                return 1000;
            }
        }

        return 0;
    }

    /**
     * fonction qui retourne la valeur d'une ligne si 2 pions de type typeJoueur
     * alignes et accolles a une case vide -> val = 200 si 1 pion de type
     * typeJoueur accolle a une case vide -> val = 30 si 2 pions de type
     * typeJoueur alignes et accolles a deux cases vides -> val = 400 si 1 pion
     * de type typeJoueur accolle a deux cases vides -> val = 60 
	 *
     */
    public int troisPionsPossiblesLigne(Boolean typeJoueur) {
        int retour = 0;

        String jeton = "";
        if (typeJoueur) {
            jeton = "1";
        } else {
            jeton = "2";
        }
        
        for (int i = 0; i < matrice.length; i++) {
            String ligne = "";
            for (int j = 0; j < matrice[i].length; j++) {
                ligne += matrice[i][j];
            }
            if (ligne.contains(jeton + jeton + "0")) {
                retour += 200;
            }
            if (ligne.contains(jeton + "0" + jeton)) {
                retour += 200;
            }
            if (ligne.contains("0" + jeton + jeton)) {
                retour += 200;
            }
            if (ligne.contains(jeton + "0")) {
                retour += 30;
            }
            if (ligne.contains("0" + jeton)) {
                retour += 30;
            }
        }

        return retour;
    }

    /**
     * fonction qui retourne la valeur d'une colonne<br>
     * si 2 pions de type typeJoueur alignes et accolles a une case vide -> val
     * = 200 <br>
     * si 1 pion de type typeJoueur accolle a une case vide -> val = 30 <br>
	 *
     */
    public int troisPionsPossiblesColonne(Boolean typeJoueur) {
        int retour = 0;

        String jeton = "";
        if (typeJoueur) {
            jeton = "1";
        } else {
            jeton = "2";
        }

        for (int i = 0; i < matrice.length; i++) {
            String colonne = "";
            for (int j = 0; j < matrice[i].length; j++) {
                colonne += matrice[j][i];
            }
            if (colonne.contains(jeton + jeton + "0")) {
                retour += 200;
            }
            if (colonne.contains(jeton + "0" + jeton)) {
                retour += 200;
            }
            if (colonne.contains("0" + jeton + jeton)) {
                retour += 200;
            }
            if (colonne.contains(jeton + "0")) {
                retour += 30;
            }
            if (colonne.contains("0" + jeton)) {
                retour += 30;
            }

        }
        
        return retour;
    }
}