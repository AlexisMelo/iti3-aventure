package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin {

	private Vivant vivant;
	private Objet[] objets;
	
	public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Objet[] objets) {
		super(etatConditionVerifiee);
		this.vivant = vivant;
		this.objets = objets.clone();
	}
	
	public EtatDuJeu verifierCondition() {
		for(Objet o : this.objets) {
			if (!this.vivant.possede(o)) {
				return EtatDuJeu.ENCOURS;
			}
		}
		return getEtatConditionVerifiee();
	}
}
