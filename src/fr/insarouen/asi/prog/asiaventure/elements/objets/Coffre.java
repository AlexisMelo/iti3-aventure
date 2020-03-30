package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

public class Coffre extends Objet implements Activable {

	public Etat etat;

	public Coffre(String nomCoffre, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nomCoffre, monde);
		this.etat = Etat.FERME;
	}

	public void activer() {
		if (this.etat.equals(Etat.FERME)) {
			this.etat = Etat.OUVERT;
		}
		else {
			this.etat = Etat.FERME;
		}
	}

	public Etat getEtat(){
		return this.etat; 
	}

	public void activerAvec(Objet obj) throws ActivationException {
		throw new ActivationException();
	}

	public boolean activableAvec(Objet obj) {
		return false;
	}

	public boolean estDeplacable() {
		return false;
	}

	public String toString() {
		return String.format("%s, l'état est : %s " ,super.toString(), this.etat);
	}
}
