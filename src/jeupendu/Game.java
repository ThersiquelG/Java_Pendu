package jeupendu;

import java.util.Scanner;

public class Game {

	public static char[] stringToCharArray(String s) {
		/*
		 * motVersTab() Permet de passer du mot � deviner en String au mot en char[]
		 * Stocker les lettres du mot � deviner en argument sous la forme d�un tableau de caract�res.
		 * Retourne un tableau de caract�res nomm� mot (char[] mot).
		 */
		char[] wordToGuess = s.toCharArray();
		return wordToGuess;
	}

	public static void display(char[] word,boolean[] check) {
		/*
		 * affiche() Permet d�afficher le mot cach� au d�but et en cours de partie
		 * Afficher le mot cach� en parcourant le tableau de bool�ens vu et en faisant appara�tre un �?� 
		 * pour chaque �l�ment false et la lettre correspondante pour chaque �l�ment true.
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
		 * metAJour() Permet de d�voiler les lettres trouv�es dans le mot cach�
		 * Parcourir le tableau de caract�res mot. 
		 * Si le caract�re c en attribut correspond au caract�re � l�index i (mot[i]), 
		 * le bool�en � l�index i du tableau de bool�ens (vu[i]) passe de false � true. 
		 * Retourne le tableau de bool�ens vu (boolean[] vu).
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
		 * partieFinie() Permet de rechercher une valeur false dans le tableau de bool�ens 
		 * Si le tableau de bool�ens vu contient une valeur false, retourner false, sinon retourner true.
		 * Retourne un bool�en.
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
		 *  partie() Permet d�appeler les m�thodes cr��es afin de faire se d�rouler la partie
		 *	Cr�er un tableau de bool�ens vu de la m�me taille que le tableau de caract�res. 
		 * Afficher le mot myst�re sous forme de ? ? ? ? 
		 * Jusqu�� ce que le mot soit d�couvert (fin de partie) , 
		 * demander � l�utilisateur d�entrer un caract�re puis  mettre � jour le tableau puis l'afficher.
		 * Afficher une derni�re fois le mot myst�re.
		 * Afficher �F�licitations, vous avez gagn� !�.
		 * Attention dans la classe Application ne doivent figurer QUE la cr�ation d'instance de Game et 
		 * la m�thode partie avec pour argument le mot myst�re entre guillemets, 
		 * ex : game1.partie(�mystere�);
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
