package fr.insarouen.asi.prog.asiaventure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

  public static Simulateur partieEnCours = null;
  
  private static void traiterChoix(int choix) {
	  switch(choix) {
		  case 1: 
			  if (partieEnCours == null) {
				  //nouvelle partie
			  }
			  System.out.println("Commande non implémentée");
			  break;
		  case 2:
			  break;
		  case 3:
			  break;
		  case 4:
			  
		  case 5:
			  System.out.println("- - - Fin du programme - - -");
		  default:
			  System.out.println(String.format("Erreur de saisie, impossible d'interpreter le choix : %s", choix));  
	  }
  }
  
  private static void menu() {
	  
	  System.out.println(" - - - Menu - - -");
	  System.out.println("1) Jouer\n"
	  		+ "2) Charger un fichier de description (format .txt)\n"
	  		+ "3) Sauvegarder la partie\n"
	  		+ "4) Charger une partie\n"
	  		+ "5) Quitter\n");
	  Scanner sc = new Scanner(System.in);
	  int choix = 0;
	  do {
		  choix = sc.nextInt();
	  }while(choix < 1 | choix > 5);
	  traiterChoix(choix);
	  sc.close();
	  
  }
  public static void main(String[] args) {
	  menu();
	  /*try {
		  
		Simulateur ancienSimulateur = new Simulateur(new BufferedReader(new FileReader("files/test.txt")));
		System.out.println(String.format("Test avant serialisation :\n %s",ancienSimulateur));
		ancienSimulateur.enregistrer(new ObjectOutputStream(new FileOutputStream("files/resultatSerialisation.txt")));
		
		Simulateur nouveauSimulateur = new Simulateur(new ObjectInputStream(new FileInputStream("files/resultatSerialisation.txt")));
		System.out.println(String.format("Test après lecture de serialisation :\n %s",nouveauSimulateur));
		
		System.out.println(ancienSimulateur.getMonde().equals(nouveauSimulateur.getMonde()));
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		System.err.println("Erreur à la création du monde");
		e.printStackTrace();
	} catch(ClassNotFoundException e) {
		System.err.println("Erreur à la désérialisation de la sauvegarde");
		e.printStackTrace();
	}*/
	
  }
}
