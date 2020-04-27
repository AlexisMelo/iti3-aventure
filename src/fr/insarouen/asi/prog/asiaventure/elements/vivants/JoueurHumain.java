package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;

public class JoueurHumain extends Vivant{

	public String ordre;

	public JoueurHumain(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets)
			throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nom, monde, pointVie, pointForce, piece, objets);
	}

	@Override
	public void executer() throws CommandeImpossiblePourLeVivantException, Throwable {

		String[] ordre = this.ordre.split(" ");
		
		Method commande = getMethodeOrdre(ordre[0], ordre.length - 1);
		commande.invoke(this, (Object[]) Arrays.copyOfRange(ordre, 1, ordre.length));

		
		
	}
	
	private Method getMethodeOrdre(String commandeString, int nbArguments) throws CommandeImpossiblePourLeVivantException {

		try {
			String methodeAChercher = String.format("commande%s", commandeString.toLowerCase());
			Class[] argumentsMethodeAChercher = new Class[nbArguments];
			Arrays.fill(argumentsMethodeAChercher,(Class)String.class);
			return this.getClass().getDeclaredMethod(methodeAChercher, argumentsMethodeAChercher);
		}catch(NoSuchMethodException | SecurityException e) {
			throw new CommandeImpossiblePourLeVivantException(String.format("Impossible pour %s d'executer la commande %s",getNom(),commandeString));
		}
		
	}
	
	
	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
	
	private void commandeprendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		prendre(nomObjet);
		System.out.println(String.format("\n> %s ramasse l'objet %s", getNom(), nomObjet));
	}
	private void commandeposer(String nomObjet) throws ObjetNonPossedeParLeVivantException {
		deposer(nomObjet);
		System.out.println(String.format("\n> %s pose l'objet %s", getNom(), nomObjet));
	}
	public void commandefranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException {
		franchir(nomPorte);
		System.out.println(String.format("\n> %s passe par la porte %s et arrive dans la pièce %s", getNom(), nomPorte, getPiece().getNom()));
	}
	
	private void commandeouvrirporte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException {
		activerActivable(this.getPiece().getPorte(nomPorte));
		System.out.println(String.format("\n> %s active la porte %s, elle est maintenant %s", getNom(), nomPorte, getPiece().getPorte(nomPorte).getEtat()));
	}
	
	private void commandeouvrirporte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException, ObjetNonPossedeParLeVivantException {
		activerActivableAvecObjet(this.getPiece().getPorte(nomPorte), getObjet(nomObjet));
		System.out.println(String.format("\n> %s active la porte %s avec , elle est maintenant %s", getNom(), nomPorte, nomObjet, getPiece().getPorte(nomPorte).getEtat()));

	} 
	
	  public String toString(){
	    return String.format("%s (Joueur Humain)[%s PV, %s PF]",getNom(), getPointVie(), getPointForce());
	  }

}
