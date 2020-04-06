package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;

public class JoueurHumain extends Vivant{

	public String ordre;
	
	public JoueurHumain(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets)
			throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nom, monde, pointVie, pointForce, piece, objets);
	}

	@Override
	public void executer() throws Throwable {
		// à faire
		
	}
	
	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
	
	public void commandePrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		prendre(nomObjet);
	}
	public void commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException {
		deposer(nomObjet);
	}
	public void commandeFranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException {
		franchir(nomPorte);
	}
	
	public void commandeOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException {
		activerActivable(this.getPiece().getPorte(nomPorte));
	}
	
	public void commandeOuvrirPorte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException, ObjetNonPossedeParLeVivantException {
		activerActivableAvecObjet(this.getPiece().getPorte(nomPorte), getObjet(nomObjet));
	}


}
