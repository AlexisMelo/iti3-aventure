package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.Map;
import java.util.Random;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;

public class Monstre extends Vivant{

	public Monstre(String nomElem, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets)
			throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nomElem, monde, pointVie, pointForce, piece, objets);
	}

	/*
	 * Action effectu�e par un monstre.
	 * Le monstre n'effectue aucune action si il est mort.
	 * Si il est vivant, il franchit d'abord une porte prise au hasard dans la pi�ce o� il se trouve.
	 * Il ne peut pas franchir une porte v�rouill�e. Si la porte est ferm�e, il l'ouvre, puis il la franchit.
	 * Quand il franchit une porte, il perd un point de vie.
	 * Une fois dans la nouvelle pi�ce, il �change tous les objets de son inventaire avec ceux au sol.
	 * 
	 * Note: si il tombe � 0 points de vie au milieu de l'execution, il continue quand m�me son action.
	 * 
	 * @see fr.insarouen.asi.prog.asiaventure.elements.Executable#executer()
	 */
	public void executer() throws Throwable {
		if (this.estMort()) {
			return;
		}
		
		//possibilit� d'am�liorer la chose en prenant les portes possibles � franchir seulement parmis
		//celles qui ne sont pas v�rouill�es !
		
		Object[] nomsPortesPossiblesAFranchir = this.getPiece().getPortes().keySet().toArray();
		String nomPorteAFranchir = (String) nomsPortesPossiblesAFranchir[new Random().nextInt(nomsPortesPossiblesAFranchir.length)];
		Porte porteAFranchir = this.getPiece().getPorte(nomPorteAFranchir);
		
		if (porteAFranchir.getEtat().equals(Etat.VEROUILLE)) {
			return;
		}
			
		if (porteAFranchir.getEtat().equals(Etat.FERME)) {
			porteAFranchir.activer();
		}
		
		franchir(porteAFranchir);
		setPointVie(getPointVie()-1);
		
		Map<String, Objet> objetDuVivantAvant = this.getObjets();
		
		for(Map.Entry<String, Objet> objet : this.getPiece().getObjets().entrySet()) {
			this.prendre(objet.getKey());
		}
		
		for(Map.Entry<String, Objet> objet : objetDuVivantAvant.entrySet()) {
			this.deposer(objet.getKey());
		}
		
			 
				
	}
}
