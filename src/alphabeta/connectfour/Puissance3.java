package alphabeta.connectfour;

public class Puissance3 {

    private int[][] matriceJeu;
    public final int WIDTH = 5;
    public final int HEIGHT = 5;
    public final int PROFONDEUR_DE_JEU = 4;

    public Puissance3() {
        matriceJeu = new int[HEIGHT][WIDTH];
    }

    /* jouer la colonne j de la matrice passé en pramètre selon le type du joueur : 
	 * jeton = 1 si MAX et jeton = 2 si MIN */
    public boolean jouer(Boolean typeJoueur, int j, int[][] matrice) {
        for (int i = matrice.length - 1; i >= 0; i--) {
            if (matrice[i][j] == 0) {
                if (typeJoueur == true) {
                    matrice[i][j] = 1;
                } else {
                    matrice[i][j] = 2;
                }
                return true;
            }
        }
        return false;
    }

    /* retourne true si c'est la fin du jeu : grille pleine, MAX a gagné ou MIN a gagné*/
    public boolean estFinJeu(Boolean typeJoueur, int[][] matrice) {
        boolean victoire = false;
        boolean full = true;
        
        String subs = "";
        if(typeJoueur){
            subs = "111";
        }
        else{
            subs = "222";
        }
        
        for(int i = 0; i < matrice.length; i++){
            
            String ligne = "";
            String colonne = "";
            
            for(int j = 0; j < matrice[i].length; j++){
                
                if(matrice[i][j] == 0){
                    full = false;
                }
                
                ligne += matrice[i][j];
                colonne += matrice[j][i];
            }
            
            if(ligne.contains(subs) || colonne.contains(subs)){
                victoire = true;
            }
            
        }
        
        return full || victoire;
    }

    /* l'algorithme alpha beta : il retourne un Objet Coup (val + noColonne) 
	 * il s'agit de l'évaluation du meilleur successeur avec le meilleur coup à jouer*/
    public Coup alpha_beta(Noeud n, int alpha, int beta, int profondeur) {

        if ((profondeur == -1) || (estFinJeu(!n.isMax(), n.getMatrice()))) {
            n.evaluer();
            return new Coup(n.getH(), -1);
        } else {
            if (n.isMax()) {
                int eval = alpha, bestj = 0;

                for (int j = 0; j < WIDTH; j++) {
                    
                    //Copier la matrice de n
                    int[][] copie = new int[HEIGHT][WIDTH];
                    copieMatrice(n.getMatrice(), copie);

                    //Jouer la colonne j donne la matrice copiée
                    
                    
                    //Créer un successeur
                    
                    
                    //Appliquer alpha_beta sur le noeud successeur et récupèrer le coup c
                    Coup c/* = new Coup()*/;

                    //Mise à jour
                    if (c.getVal() > eval) {
                        eval = c.getVal();
                        bestj = j;
                    }
                    if (eval >= beta) {
                        return new Coup(eval, bestj);
                    }

                }

                return new Coup(eval, bestj);
            }
            else{
                
            }
        }
    }

    private void copieMatrice(int[][] from, int[][] to) {
        for (int i = 0; i < HEIGHT; i++) {
            System.arraycopy(from[i], 0, to[i], 0, WIDTH);
        }
    }

    public int[][] getMatriceJeu() {
        return matriceJeu;
    }

    @Override
    public String toString() {

        String retour = "";
        for (int i = 4; i >= 0; i--) {
            retour += "\n";
            for (int j = 0; j < 5; j++) {
                retour += matriceJeu[i][j] + "|";
            }
        }
        retour += "\n------------\n";

        return retour;
    }

}
