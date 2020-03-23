package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public final class Clef extends Objet{

	protected Clef(String nomClef, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nomClef, monde);
	}
	
	public boolean estDeplacable() {
		return true;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
