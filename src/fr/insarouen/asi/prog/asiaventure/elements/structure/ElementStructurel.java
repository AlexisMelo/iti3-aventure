package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * ElementStructurel héritant d'entite qui permet de définir un élement faisant
 * partie du décors du jeu.
 *
 * @author Anna Pineau, Alexis Melo da Silva
 *
 * @see Entite
 */
public abstract class ElementStructurel extends Entite{

  /**
   * Constructeur ElementStructurel.
   *
   * A la construction d'un ElementStructurel, on lui attribue un monde auquel il appartient
   * et un nom.
   *
   * @param nomElem
   *    Le nom de l'élement structurel
   * @param monde
   *    Le monde auquel appartient l'élement structurel
   *
   * @see Monde
  */
  public ElementStructurel(String nomElem,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nomElem,monde);
  }
}
