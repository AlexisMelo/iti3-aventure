package fr.insarouen.asi.prog.asiaventure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.CommandeImpossiblePourLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;


public class Simulateur {

	private Monde monde;
	private EtatDuJeu etatDuJeu;
	private List<ConditionDeFin> mesConditions;

	public Simulateur(Monde monde, ConditionDeFin... conditionsDeFin) {
        this.monde = monde;
        this.mesConditions = new ArrayList<ConditionDeFin>();
        for (ConditionDeFin cd : conditionsDeFin) {
            this.mesConditions.add(cd);
        }
        this.etatDuJeu = EtatDuJeu.ENCOURS;
    }

	public Simulateur(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ArrayList<Serializable> mesObjetsSerialises = (ArrayList<Serializable>) ois.readObject();
		
		this.monde = (Monde) mesObjetsSerialises.remove(0);
		
		this.mesConditions = new ArrayList<ConditionDeFin>(); //intialisation à vide
		
		
		//this.mesConditions.addAll((Collection<? extends ConditionDeFin>) mesObjetsSerialises);
		
		for (Serializable ser : mesObjetsSerialises) {
			this.mesConditions.add((ConditionDeFin) ser);
		}
        this.etatDuJeu = EtatDuJeu.ENCOURS;
	}


	public Simulateur(Reader reader) throws IOException {
        this.mesConditions = new ArrayList<ConditionDeFin>();
        this.etatDuJeu = EtatDuJeu.ENCOURS;        
		Scanner sc = new Scanner(reader);

		while(sc.hasNextLine()) {
			interpreterLigne(sc.nextLine());
		}

		sc.close();

	}

	public EtatDuJeu getEtatDuJeu() {
		return this.etatDuJeu;
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
		case "ConditionDeFinVivantDansPiece" :{
			try{
				this.mesConditions.add(new ConditionDeFinVivantDansPiece(EtatDuJeu.valueOf(argumentsConstructeur[0]),(Vivant)this.monde.getEntite(argumentsConstructeur[1]),(Piece)this.monde.getEntite(argumentsConstructeur[2])));
			} catch (Exception e){
				e.printStackTrace();
				throw new IOException(String.format("Impossible de créer la condition de fin vivant dans piece %s avec le vivant %s et la pièce %s", argumentsConstructeur[0], argumentsConstructeur[1], argumentsConstructeur[2]));
			}
			break;
		}
		case "ConditionDeFinVivantMort" :{
			try{
				this.mesConditions.add(new ConditionDeFinVivantMort(EtatDuJeu.valueOf(argumentsConstructeur[0]),(Vivant)this.monde.getEntite(argumentsConstructeur[1])));
			} catch (Exception e){
				e.printStackTrace();
				throw new IOException(String.format("Impossible de créer la condition de fin vivant est mort %s avec le vivant %s ", argumentsConstructeur[0], argumentsConstructeur[1]));
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
		ArrayList<Serializable> objetsASerialiser = new ArrayList<Serializable>();
		objetsASerialiser.add(this.monde);
		objetsASerialiser.add((Serializable)this.mesConditions);
		
		try {
			oos.writeObject(objetsASerialiser);
		} catch (IOException e) {
			System.err.println("Erreur lors de la sauvegarde");
			e.printStackTrace();
		}
		System.out.println("Sauvegarde terminée");
	}

	
	public EtatDuJeu executerUnTour() throws Throwable {
		
		for (Executable e : this.monde.getExecutables()) {
			if (e instanceof JoueurHumain) { //traitement des joueurs humains
				
				boolean ordreCorrect = false;
				System.out.println(String.format("\nC'est à %s de jouer", ((JoueurHumain) e).getNom()));
				afficherSituationJoueur((JoueurHumain)e); //affichage etat du joueur humain
				
				do {
					System.out.println("\nQue voulez vous faire ? Entrez un ordre sous la forme <ordre> <argument1> <argument2> ..., et faites attention aux majuscules !");
					try {
						((JoueurHumain) e).setOrdre((new Scanner(System.in)).nextLine());
						e.executer();
						ordreCorrect = true;
					} catch (CommandeImpossiblePourLeVivantException exc) {
						System.err.println(exc.getMessage());
					} catch (InvocationTargetException ie) {
						System.err.println(String.format("Impossible d'effectuer la commande voulue pour la raison suivante : %s", ie));
					}
				} while(!ordreCorrect);
				
				System.out.println("Tour effectué sans accroc, au suivant ! ");
			}
		}
		//obligé de refaire une boucle car tous les joueurs humains doivent jouer d'abord PUIS tous les executables jouent leur tour
		for (Executable e : this.monde.getExecutables()) {
			if (!(e instanceof JoueurHumain)) {
				e.executer();
			}
		}
		
		for (ConditionDeFin cd : this.mesConditions) {
			if (!cd.verifierCondition().equals(EtatDuJeu.ENCOURS)) {
				return cd.verifierCondition();
			}
		}
		
		return EtatDuJeu.ENCOURS;
		
	}
	
	public EtatDuJeu executerJusquALaFin () throws Throwable {
		EtatDuJeu etat = EtatDuJeu.ENCOURS;
		
		do {
			etat = executerUnTour();

		} while(etat.equals(EtatDuJeu.ENCOURS));
		
		System.out.println("Partie terminée !");
		
		if (etat.equals(EtatDuJeu.ECHEC)) {
			System.out.println("Vous avez échoué.");
		}
		else {
			System.out.println("Félicitations ! Vous avez remporté la partie !");
		}
		return etat;
	}
 

	public void ajouterConditionsDeFin(List<ConditionDeFin> conditions) {
		for (ConditionDeFin cdf : conditions){
			ajouterConditionDeFin(cdf);
		}
	}

	public void ajouterConditionDeFin(ConditionDeFin condition) {
		this.mesConditions.add(condition);
	}

	public void afficherSituationJoueur(JoueurHumain j) {
		StringBuilder sb = new StringBuilder();
		
		if (j.estMort()) {
			sb.append("\nVous êtes mort");
		}
		else {
			sb.append(String.format("\nVous avez %s points de vie, %s points de force.", j.getPointVie(), j.getPointForce()));
			
			Map<String,Objet> objetsDuJoueur = j.getObjets();
			
			if (objetsDuJoueur.isEmpty()) {
				sb.append("\nVous n'avez aucun objet pour l'instant.");
			}
			else {
				StringBuilder sbObjets = new StringBuilder();
				for (Objet o : objetsDuJoueur.values()) {
					sbObjets.append(String.format("\n   %s", o));
				}
				sb.append(String.format("\nVous possédez les objets suivants : \n%s", sbObjets));
			}
			
			sb.append(String.format("\nVous êtes dans la pièce %s", j.getPiece().getNom()));
			
			Map<String,Objet> objetsDeLaPiece = j.getPiece().getObjets();
			
			if (objetsDeLaPiece.isEmpty()) {
				sb.append("\n- Elle ne comporte aucun objet.");
			}
			else {
				StringBuilder sbObjets = new StringBuilder();
				for (Objet o : objetsDeLaPiece.values()) {
					sbObjets.append(String.format("\n   %s", o));
				}
				sb.append(String.format("\n- Elle comporte les objets suivants : \n%s", sbObjets));
			}
			
			Map<String,Porte> portesDeLaPiece = j.getPiece().getPortes();
			
			if (portesDeLaPiece.isEmpty()) {
				sb.append("\n- Elle ne possède aucune porte... Vous semblez être coincé !");
			}
			else {
				StringBuilder sbPortes = new StringBuilder();
				for (Porte p : portesDeLaPiece.values()) {
					sbPortes.append(String.format("\n   %s", p));
				}
				sb.append(String.format("\n- Elle possède les portes suivantes : \n%s\n",sbPortes));
			}
			
			Map<String,Vivant> vivantsDeLaPiece = j.getPiece().getVivants();
			
			if (vivantsDeLaPiece.size() <= 1) {
				sb.append("\n- Il semble qu'il n'y ai aucun autre vivant dans la pièce...");
			}
			else {
				StringBuilder sbVivants = new StringBuilder();
				for (Vivant v : vivantsDeLaPiece.values()) {
					sbVivants.append(String.format("\n   %s", v));
				}
				sb.append(String.format("\n- Les vivants suivants sont avec vous : \n%s",sbVivants));
			}
			
		}
		
		System.out.println(sb);
	}
	
	public String toString() {
		return String.format("Simulateur pour le monde : %s, avec les conditions de fin : %s", this.monde, this.mesConditions);
	}
}
