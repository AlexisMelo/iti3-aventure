package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFin {

	private Vivant vivant;
	private Piece piece;
	private Objet[] objets;
	
	public ConditionDeFinVivantDansPieceEtPossedeObjets (EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece, Objet[] objets) {
		super(etatConditionVerifiee);
		this.vivant = vivant;
		this.piece = piece;
		this.objets = objets.clone();
	}
	
	public EtatDuJeu verifierCondition() {
		ConditionDeFin cd1 = new ConditionDeFinVivantDansPiece(getEtatConditionVerifiee(), this.vivant, this.piece);
		ConditionDeFin cd2 = new ConditionDeFinVivantPossedeObjets(getEtatConditionVerifiee(), this.vivant, this.objets);
		
		if (cd1.verifierCondition().equals(getEtatConditionVerifiee()) && cd2.verifierCondition().equals(getEtatConditionVerifiee())) return getEtatConditionVerifiee();
		return EtatDuJeu.ENCOURS;
	}
}
