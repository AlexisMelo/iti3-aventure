package fr.insarouen.asi.asiaventure.elements.objets;

import fr.insarouen.asi.asiaventure.elements.objets.Objet;

public class PiedDeBiche extends Objet{

  public PiedDeBiche(String nomObjet, Monde monde){
    super(nomObjet,monde);
  }

  public boolean estDeplacable(){
    return true;
  }


}
