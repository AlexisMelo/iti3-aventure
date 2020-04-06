package fr.insarouen.asi.prog.asiaventure;

import java.util.List;

public class ConditionDeFinConjonctionDeConditionDeFin extends ConditionDeFin {

	private ConditionDeFin[] mesConditions;
	
	public ConditionDeFinConjonctionDeConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin[] cfs) {
		super(etatDuJeu);
		this.mesConditions = cfs.clone();
	}
	
	public EtatDuJeu verifierCondition() {
		
		for (ConditionDeFin cd : mesConditions) {
			if (cd.verifierCondition().equals(EtatDuJeu.ENCOURS)) return EtatDuJeu.ENCOURS;
		}
		return getEtatConditionVerifiee();
		
	}
	
	
}
