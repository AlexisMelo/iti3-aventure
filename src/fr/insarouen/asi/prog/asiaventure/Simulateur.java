package fr.insarouen.asi.prog.asiaventure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;

public class Simulateur {
	
	private Monde monde;
	private EtatDuJeu etatDuJeu;
	private List<ConditionDeFin> mesConditions;
	
	
	public Simulateur(Monde monde, List<ConditionDeFin> conditionsDeFin) {
		this.monde = monde;
		this.mesConditions.addAll(conditionsDeFin);
		this.etatDuJeu = EtatDuJeu.ENCOURS;
	}
	
	public Simulateur(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		this.monde = (Monde)ois.readObject();
	}
	
	public EtatDuJeu getEtatDuJeu() {
		return this.etatDuJeu;
	}
	public Simulateur(Reader reader) throws IOException {
		Scanner sc = new Scanner(reader);

		while(sc.hasNextLine()) {
			interpreterLigne(sc.nextLine());
		}
		
		sc.close();
		
	}
	
	public Monde getMonde() {
		return this.monde;
	}
	

	private void interpreterClasse(String nomClasse, String[] argumentsConstructeur) throws IOException {
		switch(nomClasse) {
		case "Monde" :
			try {
				this.monde = new Monde(argumentsConstructeur[0]);
			}catch (Exception e) {
				throw new IOException(String.format("Impossible de créer le monde avec les arguments : %s", Arrays.toString(argumentsConstructeur)));
			}
			break;
		case "Piece" : {
			try {
				new Piece(argumentsConstructeur[0], this.monde);
			}catch (Exception e) {
				e.printStackTrace();
				throw new IOException(String.format("Impossible de créer une pièce avec les arguments : %s", Arrays.toString(argumentsConstructeur)));
			}
			break;
		}
		case "PorteSerrure" : {
			try {
				new Porte(argumentsConstructeur[0], this.monde, new Serrure(this.monde), (Piece)this.monde.getEntite(argumentsConstructeur[1]), (Piece)this.monde.getEntite(argumentsConstructeur[2]));
			}catch (Exception e) {
				throw new IOException(String.format("Impossible de créer une porte avec serrure avec les arguments : %s", Arrays.toString(argumentsConstructeur)));
			}
			break;
		}
		case "Porte" : {
			try {
				new Porte(argumentsConstructeur[0], this.monde, (Piece)this.monde.getEntite(argumentsConstructeur[1]), (Piece)this.monde.getEntite(argumentsConstructeur[2]));
			}catch (Exception e) {
				throw new IOException(String.format("Impossible de créer une porte sans serrure avec les arguments : %s", Arrays.toString(argumentsConstructeur)));
			}
			break;
		}
		case "Clef" : {
			try {
				Porte porte = (Porte)this.monde.getEntite(argumentsConstructeur[0]);
				Clef clef = porte.getSerrure().creerClef();
				((Piece)this.monde.getEntite(argumentsConstructeur[1])).deposer(clef);
			}catch (Exception e) {
				throw new IOException(String.format("Impossible de créer une clef avec les arguments : %s", Arrays.toString(argumentsConstructeur)));
			}
			break;
		}
		case "JoueurHumain" : {
			try {
				new JoueurHumain(argumentsConstructeur[0], this.monde, Integer.parseInt(argumentsConstructeur[1]), Integer.parseInt(argumentsConstructeur[2]), (Piece)this.monde.getEntite(argumentsConstructeur[3]), new Objet[0]);
			}catch (Exception e) {
				throw new IOException(String.format("Impossible de créer un joueur humain avec les arguments : %s", Arrays.toString(argumentsConstructeur)));
			}
			break;
		}
		default : 
			throw new IOException(String.format("Impossible de créer objet désiré :\n Classe : %s\n Arguments : %s\n", nomClasse, Arrays.toString(argumentsConstructeur)));
		}
	}
	
	private void interpreterLigne(String ligne) throws IOException {
		String[] lesMots = ligne.split(" ",2);
		
		interpreterClasse(lesMots[0], lesMots[1].split(" "));
	}
	
	
	public void enregistrer(ObjectOutputStream oos) {
		System.out.println("Sauvegarde en cours");
		try {
			oos.writeObject(this.monde);
		} catch (IOException e) {
			System.err.println("Erreur lors de la sauvegarde");
			e.printStackTrace();
		}
		System.out.println("Sauvegarde terminée");
	}
	
	/*
	public void executer() {
		// à faire
	}
	
	public void ajouterConditionsDeFin(Collection<ConditionDeFin> conditions) {
		//à faire
	}
	
	public void ajouterConditionDeFin(ConditionDeFin condition) {
		//à faire
	}*/
	
	public String toString() {
		return String.format("Simulateur pour le monde : %s", monde);
	}
}
