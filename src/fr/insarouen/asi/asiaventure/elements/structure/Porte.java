package fr.insarouen.asi.asiaventure.elements.structure;

import fr.insarouen.asi.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


public class Porte extends ElementStructurel{


  /**
   * Constructeur Porte.
   *
   * A la construction d'une porte, un nom et un monde lui sont attribués.
   *
   * @see ElementStructurel
   *
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Porte(String nom, Monde monde)  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }

}
