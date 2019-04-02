package alphabeta.connectfour;

public class Puissance3 {

	private int[][] matriceJeu;
	public  final int WIDTH = 5;
	public  final int HEIGHT = 5;
	public final int PROFONDEUR_DE_JEU = 4;

	public Puissance3()
	{
		matriceJeu = new int[HEIGHT][WIDTH];
	}

	
	/* jouer la colonne j de la matrice passé en pramètre selon le type du joueur : 
	 * jeton = 1 si MAX et jeton = 2 si MIN */
	
	public boolean jouer(Boolean typeJoueur, int j, int[][] matrice)
	{
		
				
		return true;
	}
	
	/* retourne true si c'est la fin du jeu : grille pleine, MAX a gagné ou MIN a gagné*/

	public boolean estFinJeu(Boolean typeJoueur, int [][] matriceJeu)
	{
		boolean victoire = false;
		boolean full = true;
		
		
		
		return full||victoire;
	}

	/* l'algorithme alpha beta : il retourne un Objet Coup (val + noColonne) 
	 * il s'agit de l'évaluation du meilleur successeur avec le meilleur coup à jouer*/
	
	public Coup alpha_beta(Noeud n , int alpha, int beta, int profondeur) 
	{
		
		return null;			
	}
	
	
	private void copieMatrice(int [][]from, int[][]to)
	{
		for(int i=0; i<HEIGHT; i++)
			System.arraycopy(from[i], 0, to[i], 0, WIDTH);
	}
	

	public int[][] getMatriceJeu() {
		return matriceJeu;
	}
	
	
	
	@Override
	public String toString() {
		
		String retour = "";
		for(int i=4; i>=0; i--)
		{
			retour += "\n";
			for(int j=0; j<5; j++)
			{
				retour += matriceJeu[i][j]+"|";
			}
		}
		retour += "\n------------\n";
				
		return retour;
	}

	

}
