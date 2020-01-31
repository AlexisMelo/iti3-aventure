package fr.insarouen.asi.asiaventure.elements.objets;

import fr.insarouen.asi.asiaventure.elements.objets.Objet;

/**
 * PiedDeBiche héritant d'objet qui permet d'obtenir un objet pied de biche.
 *
 * @author Anna Pineau, Alexis Melo da Silva
 *
 * @see Objet
*/
public class PiedDeBiche extends Objet{

  /**
   * Constructeur PiedDeBiche.
   *
   * A la construction d'un PiedDeBiche, on lui attribue un monde auquel il appartient
   * et un nom.
   *
   * @param nomPiedDeBiche
   *    Le nom du pied de biche
   * @param monde
   *    Le monde auquel appartient le pied de biche
   *
   * @see Monde
  */
  public PiedDeBiche(String nomPiedDeBiche, Monde monde){
    super(nomPiedDeBiche,monde);
  }

  /**
   * Permet de savoir si l'objet est déplaçable. Un pied de biche est par défaut
   * déplaçable.
   *
   * @return booléen vrai.
  */
  public boolean estDeplacable(){
    return true;
  }


}
