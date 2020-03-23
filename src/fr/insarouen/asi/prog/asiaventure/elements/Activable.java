package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/*
 * Activable est une interface qui va permettre de gérer les intercations qu'ont les entités avec des objets.
 * Par exemple une porte peut être activée avec une clef, ou un coffre peut être activé pour passer de l'état ouvert à fermé.
 */
public interface Activable {
	
	/*
	 * Permet de savoir si une entité peut être activée à l'aide d'un objet.
	 * 
	 * @see Entite
	 */
	public abstract boolean activableAvec(Objet obj);
	
	/*
	 * Permet de faire changer d'état une entité.
	 */
	public abstract void activer() throws ActivationException;

	/*
	 * Permet de faire changer d'état une entité à l'aide d'un objet.
	 */
	public abstract void activerAvec(Objet obj) throws ActivationException;
}
