package jeupendu;

import java.util.Scanner;

public class Game {

	public static char[] stringToCharArray(String s) {
		/*
		 * motVersTab() Permet de passer du mot à deviner en String au mot en char[]
		 * Stocker les lettres du mot à deviner en argument sous la forme d’un tableau de caractères.
		 * Retourne un tableau de caractères nommé mot (char[] mot).
		 */
		char[] wordToGuess = s.toCharArray();
		return wordToGuess;
	}

	public static void display(char[] word,boolean[] check) {
		/*
		 * affiche() Permet d’afficher le mot caché au début et en cours de partie
		 * Afficher le mot caché en parcourant le tableau de booléens vu et en faisant apparaître un ‘?’ 
		 * pour chaque élément false et la lettre correspondante pour chaque élément true.
		 *	Ne retourne rien. 
		 */

		for(int i= 0 ; i<word.length; i++) {
			if(check[i] == false) {
				System.out.print('?');
			} else {
				System.out.print(word[i]);
			}
		}
	}

	public static boolean[] updateArray(char[]word,boolean[]check, char c) {
		/*
		 * metAJour() Permet de dévoiler les lettres trouvées dans le mot caché
		 * Parcourir le tableau de caractères mot. 
		 * Si le caractère c en attribut correspond au caractère à l’index i (mot[i]), 
		 * le booléen à l’index i du tableau de booléens (vu[i]) passe de false à true. 
		 * Retourne le tableau de booléens vu (boolean[] vu).
		 */

		for(int i = 0; i<word.length; i++) {
			if(c == word[i]) {
				check[i] = true;
			}
		}
		return check;
		}
	
	public static boolean gameOver(boolean[] check) {
		/*
		 * partieFinie() Permet de rechercher une valeur false dans le tableau de booléens 
		 * Si le tableau de booléens vu contient une valeur false, retourner false, sinon retourner true.
		 * Retourne un booléen.
		 */

		for(int i = 0; i<check.length; i++) {
			if(check[i] == false) {
				return true;
			}
		}
		return false;
		}

	public void startGame(String wordToGuess) {
		/*
		 *  partie() Permet d’appeler les méthodes créées afin de faire se dérouler la partie
		 *	Créer un tableau de booléens vu de la même taille que le tableau de caractères. 
		 * Afficher le mot mystère sous forme de ? ? ? ? 
		 * Jusqu’à ce que le mot soit découvert (fin de partie) , 
		 * demander à l’utilisateur d’entrer un caractère puis  mettre à jour le tableau puis l'afficher.
		 * Afficher une dernière fois le mot mystère.
		 * Afficher “Félicitations, vous avez gagné !”.
		 * Attention dans la classe Application ne doivent figurer QUE la création d'instance de Game et 
		 * la méthode partie avec pour argument le mot mystère entre guillemets, 
		 * ex : game1.partie(“mystere”);
		 */		
		Scanner reader = new Scanner(System.in);
		
		boolean[] check = new boolean[stringToCharArray(wordToGuess).length];
		System.out.println("Please enter one character at the time until the word is discovered.");
		while(gameOver(check)) {
			display(stringToCharArray(wordToGuess), check);
			char c = reader.next(".").charAt(0);
			updateArray(stringToCharArray(wordToGuess), check, c);
		}
		System.out.println("Congrulation !! The word was " + wordToGuess);
	}
}
