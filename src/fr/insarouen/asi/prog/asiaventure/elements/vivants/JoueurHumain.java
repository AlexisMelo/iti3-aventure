package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.lang.reflect.Method;

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

		String[] ordre = this.ordre.split(" ", 1);
		
		Method commande = getMethodeOrdre(ordre[0]);
		
		commande.invoke(this, (Object[]) ordre[1].split(" "));
		
	}
	
	private Method getMethodeOrdre(String commandeString) throws SecurityException, CommandeImpossiblePourLeVivantException {
		try {
			return this.getClass().getDeclaredMethod(String.format("commande%s", commandeString.toLowerCase()));
		}catch(NoSuchMethodException e) {
			throw new CommandeImpossiblePourLeVivantException("Impossible pour %s d'executer la commande %s");
		}
		
	}
	
	
	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
	
	private void commandeprendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		prendre(nomObjet);
	}
	private void commandeposer(String nomObjet) throws ObjetNonPossedeParLeVivantException {
		deposer(nomObjet);
	}
	private void commandefranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException {
		franchir(nomPorte);
	}
	
	private void commandeouvrirporte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException {
		activerActivable(this.getPiece().getPorte(nomPorte));
	}
	
	private void commandeouvrirporte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException, ObjetNonPossedeParLeVivantException {
		activerActivableAvecObjet(this.getPiece().getPorte(nomPorte), getObjet(nomObjet));
	}


}
