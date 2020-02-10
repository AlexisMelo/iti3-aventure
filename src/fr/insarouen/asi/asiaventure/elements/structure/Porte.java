package fr.insarouen.asi.asiaventure.elements.structure;

import fr.insarouen.asi.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


public class Porte extends ElementStructurel{

  public Porte(String nom, Monde monde)  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }

}
