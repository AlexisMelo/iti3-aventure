package fr.insarouen.asi.prog.asiaventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static String nomPartieEnCours = null;
	private static Simulateur partieEnCours = null;

	private static void jouer() {
		if (nomPartieEnCours == null) {
			nouvellePartie();
		}
		else {
			System.out.println(String.format("- - - Lancement de la partie - - -"));
			System.out.println("Fonction non implantée pour l'instant.");
		}
	}

	private static void nouvellePartie() {
		System.out.println("Aucune partie chargée actuellement. Voulez-vous créer une nouvelle partie ?\n (O)ui / (N)on");
		if (!saisirChoixBoolean()) return;
		System.out.println("Création d'une nouvelle partie. Fonction non implantée pour l'instant.");	  
	}

	private static void chargerFichierDescription() {
		try {
			System.out.println("Chargement d'un fichier de description.\nNom du fichier : ");
			
			File fichierACharger = new File(String.format("files/%s.txt",saisirString()));
			
			partieEnCours = new Simulateur(new BufferedReader(new FileReader(fichierACharger)));
			nomPartieEnCours = getFileNameWithoutExtension(fichierACharger);
			
			System.out.println("Fichier chargé avec succès !");
		}catch(FileNotFoundException e) {
			System.err.println("Erreur de chargement de fichier. Assurez vous que le fichier existe et est positionné dans le dossier \"files\" à la racine et qu'il est au format .txt");
		} catch (IOException e) {
			System.err.println(String.format("Erreur lors de l'interprétation du fichier pour la raison suivante : \n%s",e));
		}
	}

	private static void sauvegarderPartie() {
		if (nomPartieEnCours == null) {
			System.err.println("Aucune partie en cours, impossible de sauvegarder.");
			return;
		}		

		File saveLocation = new File(String.format("files/%s.save",nomPartieEnCours)); //modifié plus tard si le joueur ne veut pas écraser la sauvegarde actuelle;
		
		if (saveLocation.exists()) {
			System.out.println("Une sauvegarde existe déjà. Faites un choix parmis les propositions suivantes :\n"
					+ "1) Ecraser la sauvegarde actuelle\n"
					+ "2) Donner un nouveau nom pour la sauvegarde\n"
					+ "3) Ne rien faire et retourner au menu");
			int choix = saisirChoixInt(1,3);
			switch (choix) {
			case 1:
				break; //rien à faire, c'est le comportement par défaut
			case 2:
				
				do {
					System.out.println("Veuillez renseigner un nouveau nom pour votre partie, il correspondra aussi au nom du fichier de sauvegarde.\nNouveau nom : ");
					saveLocation = new File(String.format("files/%s.save",saisirString()));
				}while(saveLocation.exists()); //tant qu'on rentre un nom de fichier qui existe déjà
				
				try {
					saveLocation.createNewFile();
				} catch (IOException e) {
					System.err.println("Erreur à la création du fichier. Assurez vous d'avoir les droits d'écriture dans le dossier destination.");
					e.printStackTrace();
					return; // sinon on continue l'execution de la sauvegarde
				}
				break;
			case 3:
				return; //return au lieu de break pour repartir direct au menu sans sauvegarder
			}
		}
				
		try {
			partieEnCours.enregistrer(new ObjectOutputStream(new FileOutputStream(saveLocation,false)));
			System.out.println(String.format("Sauvegarde effectuée avec succès ! (Emplacement : %s)", saveLocation.getAbsolutePath()));
			nomPartieEnCours = getFileNameWithoutExtension(saveLocation);
			
		} catch (IOException e) {
			System.err.println("Erreur à la création du fichier.");
			e.printStackTrace();
		} 
	}

	private static void chargerPartie() {
		System.out.println("Quelle partie voulez vous charger ?\nNom de la sauvegarde : ");
		File fichierSauvegarde = new File(String.format("files/%s.save",saisirString()));

		try {
			partieEnCours = new Simulateur(new ObjectInputStream(new FileInputStream(fichierSauvegarde)));
			nomPartieEnCours = getFileNameWithoutExtension(fichierSauvegarde);
			
			System.out.println("Partie chargée avec succès !");
			
		} catch (FileNotFoundException e) {
			System.err.println("Erreur au chargement de la partie. Vérifiez que la sauvegarde existe dans le dossier files/ et est bien au format .save");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Erreur à la lecture du fichier pour le transformer en partie. La sauvegarde est peut être corrompue. Avez-vous modifié son contenu manuellement ?");
			e.printStackTrace();
		} 
	}

	private static void traiterChoix(int choix) {
		switch(choix) {
		case 1: 
			jouer();
			break;
		case 2:
			chargerFichierDescription();
			break;
		case 3:
			sauvegarderPartie();
			break;
		case 4:
			chargerPartie();
			break;
		default:
			System.out.println(String.format("Erreur de saisie, impossible d'interpreter le choix : %s", choix));  
		}
	}

	private static String affichagePartie() {
		if (nomPartieEnCours == null) return "(Aucune partie chargée)";
		return String.format("(%s)",nomPartieEnCours);
	}
	private static void menu() {
		int choix = -1;
		do {
			System.out.println(" - - - Menu - - -");
			System.out.println(String.format("1) Jouer %s\n",affichagePartie())
					+ "2) Charger un fichier de description (format .txt)\n"
					+ "3) Sauvegarder la partie\n"
					+ "4) Charger une partie\n"
					+ "5) Quitter\n");
			choix = saisirChoixInt(1,5);
			if (choix != 5) {traiterChoix(choix);};
		} while(choix != 5);
		System.out.println("- - - Fin d'exécution du programme - - -");

	}
	
	private static boolean saisirChoixBoolean() {
		Scanner sc = new Scanner(System.in);
		String choix = "-1";
		try {
			choix = sc.next("[oOnN]"); 
		} catch(InputMismatchException e) {
			System.err.println("Erreur de saisie. Valeurs possibles : {o, O, n, N}");
			return saisirChoixBoolean();
		}

		System.out.println(choix);
		if (choix.equals("o")) return true;
		return false;
	}

	private static String saisirString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private static int saisirChoixInt(int borneMin, int borneMax) {
		int choix = -1;
		Scanner sc = new Scanner(System.in);
		do {
			choix = sc.nextInt();
		}while(choix < borneMin && choix > borneMax);
		return choix;
	}

	private static String getFileNameWithoutExtension(File file) {
		return file.getName().replaceFirst("[.][^.]+$", ""); //https://stackoverflow.com/a/924519
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
