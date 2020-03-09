package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


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
