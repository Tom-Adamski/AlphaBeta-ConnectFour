package alphabeta.connectfour;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Puissance3 puissance3 = new Puissance3();
        
        Scanner scanner = new Scanner(System.in);
        Coup coup = null;
        boolean max = false;
        
        
        while(!puissance3.estFinJeu(Boolean.TRUE, puissance3.getMatriceJeu())
                && !puissance3.estFinJeu(Boolean.FALSE, puissance3.getMatriceJeu())){
            
            if(max){
                Noeud n = new Noeud(true, puissance3.getMatriceJeu());
                coup = puissance3.alpha_beta(n, 0, Integer.MAX_VALUE, puissance3.PROFONDEUR_DE_JEU);
                if(coup != null)
                    puissance3.jouer(true, coup.getNoColonne(), puissance3.getMatriceJeu());
            }
            else{
                System.out.println(puissance3.toString());
                System.out.println("Entrez le numéro de la colonne à jouer :");
                int j = -1;
                do{
                    j = scanner.nextInt();
                }while(j<0 || j>=puissance3.WIDTH);
                puissance3.jouer(false, j, puissance3.getMatriceJeu());
                System.out.println(puissance3.toString());    
            }    
        }
        
        if(puissance3.estFinJeu(Boolean.TRUE, puissance3.getMatriceJeu())){
            System.out.println("AlphaBeta a gagné");
        }
        else if(puissance3.estFinJeu(Boolean.FALSE, puissance3.getMatriceJeu())){
            System.out.println("Le joueur a gagné");
        }
        
    }
}

