package jeupendu;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the hangman Game.");
		System.out.println("Please type in a word for your friend to guess, then let him/her player.");
		System.out.println("Enjoy the game !");
		String userChoice = sc.next();
		
		Game partie = new Game();
		partie.startGame(userChoice);
			
		}

		
	}
