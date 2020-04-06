package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantDansPiece extends ConditionDeFin{
	
	private Vivant vivant;
	private Piece piece;
	
	public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee, Vivant vivant2, Piece piece) {
		super(etatConditionVerifiee);
		this.vivant = vivant2;
		this.piece = piece;
	}
	
	public EtatDuJeu verifierCondition () {
		if (this.piece.contientVivant(this.vivant)) {
			return getEtatConditionVerifiee();
		}
		return EtatDuJeu.ENCOURS;
	}
}
