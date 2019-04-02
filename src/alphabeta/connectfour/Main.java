package alphabeta.connectfour;


public class Main {

    public static void main(String[] args) {

        int[][] test = { 
            {0,0,0,0,0}, 
            {0,0,0,0,0}, 
            {0,0,0,0,0}, 
            {0,1,0,0,0}, 
            {0,1,2,2,0}
        };
        
        Noeud noeud = new Noeud(true, test);
        
        noeud.evaluer();
        System.out.println("H : " +noeud.getH());
        
        System.out.println(noeud.troisPionsPossiblesLigne(true));
        System.out.println(noeud.troisPionsPossiblesLigne(false));
        System.out.println(noeud.troisPionsPossiblesColonne(true));
        System.out.println(noeud.troisPionsPossiblesColonne(false));
        
    }

}
