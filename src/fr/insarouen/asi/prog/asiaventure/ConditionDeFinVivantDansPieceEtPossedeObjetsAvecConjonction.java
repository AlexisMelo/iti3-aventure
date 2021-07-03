package fr.insarouen.asi.prog.asiaventure;

import java.util.List;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction extends ConditionDeFinConjonctionDeConditionDeFin {

	public ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece, Objet[] objets) {
		super(etatConditionVerifiee, new ConditionDeFin[] {new ConditionDeFinVivantDansPiece(etatConditionVerifiee, vivant, piece),new ConditionDeFinVivantPossedeObjets(etatConditionVerifiee, vivant, objets)});		
	}
}
