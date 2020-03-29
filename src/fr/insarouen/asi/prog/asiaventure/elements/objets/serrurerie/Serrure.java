package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class Serrure extends Objet implements Activable{

	private Clef clef;
	private Etat etat;

	private static int nombreSerrure = 0;
	private static int tentativeCreationCle = 0;

	public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(String.format("serrure %s", nombreSerrure), monde);
		System.out.println(String.format("serrure %s créée !", nombreSerrure));
		this.clef = null;
		nombreSerrure++;
		this.etat = Etat.VEROUILLE;
	}

	public Serrure(String nomSerrure, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nomSerrure, monde);
		this.clef = null;
		nombreSerrure++;
		this.etat = Etat.VEROUILLE;
	}

	public final Clef creerClef() {

		if (this.clef != null) {
			return null;
		}

		boolean clefCree = false;

		while(!clefCree) {
			try {
				this.clef = new Clef(String.format("clef %d pour ouvrir : %s", tentativeCreationCle, getNom()), this.getMonde());
				clefCree = true;
			} catch (NomDEntiteDejaUtiliseDansLeMondeException e) {
				tentativeCreationCle++;
			}
		}

		return this.clef;
	}

	public void activer() throws ActivationImpossibleException {
		throw new ActivationImpossibleException();
	}

	public boolean activableAvec(Objet obj) {
		if (obj == null) {
			return false;
		}
		if (obj.equals(this.clef)) {
			return true;
		}
		return false;
	}

	public Etat getEtat() {
		return this.etat;
	}

	public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException {
		if (!activableAvec(obj)) {
			throw new ActivationImpossibleAvecObjetException();
		}

		if (getEtat().equals(Etat.VEROUILLE)) {
			this.etat = Etat.DEVEROUILLE;
		}
		else {
			this.etat = Etat.VEROUILLE;
		}

	}

	public boolean estDeplacable() {
		return false;
	}

	public String toString() {
		return String.format("%s, l'état est %s, elle s'ouvre avec la clé : %s ", super.toString(), this.etat, this.clef);
	}
}
