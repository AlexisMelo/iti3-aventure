package fr.insarouen.asi.asiaventure.elements.objets;

import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.Monde;

/**
 * Objet est une classe héritant d'Entité représentant des élements du jeu avec
 * lesquelles le joueur pourra intéragir en les ramassant, déplaçant, utilisant, etc...
 *
 * @author Anna Pineau, Alexis Melo da Silva
 *
 * @see Entite
*/
public class Objet extends Entite{

  /**
   * Constructeur Objet.
   *
   * A la construction d'un objet, on lui attribue un monde auquel il appartient
   * et un nom.
   *
   * @param nomObjet
   *    Le nom de l'objet
   * @param monde
   *    Le monde auquel appartient l'objet
   *
   * @see Monde
   */
  public Objet(String nomObjet, Monde monde){
    super(nomObjet,monde);
  }

  /**
   * Permet de savoir si un objet est déplaçable.
   *
   * @return Un booléen à vrai si l'objet est déplaçable, faux sinon.
   */
  public boolean estDeplacable(){
    return false;
  }


}