package fr.insarouen.asi.asiaventure.elements.objets;

import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.Monde;

public class Objet extends Entite{

  public Objet(String nomObjet, Monde monde){
    super(nomObjet,monde);
  }

  public boolean estDeplacable(){
    return false;
  }


}
