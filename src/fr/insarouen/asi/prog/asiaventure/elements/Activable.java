package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/*
 * Activable est une interface qui va permettre de g�rer les intercations qu'ont les entit�s avec des objets.
 * Par exemple une porte peut �tre activ�e avec une clef, ou un coffre peut �tre activ� pour passer de l'�tat ouvert � ferm�.
 */
public interface Activable {
	
	/*
	 * Permet de savoir si une entit� peut �tre activ�e � l'aide d'un objet.
	 * 
	 * @see Entite
	 */
	public abstract boolean activableAvec(Objet obj);
	
	/*
	 * Permet de faire changer d'�tat une entit�.
	 */
	public abstract void activer() throws ActivationException;

	/*
	 * Permet de faire changer d'�tat une entit� � l'aide d'un objet.
	 */
	public abstract void activerAvec(Objet obj) throws ActivationException;
}
