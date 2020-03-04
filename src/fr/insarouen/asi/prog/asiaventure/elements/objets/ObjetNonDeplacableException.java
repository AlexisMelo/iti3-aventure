package fr.insarouen.asi.asiaventure.elements.objets;

import fr.insarouen.asi.asiaventure.elements.objets.ObjetException;

public class ObjetNonDeplacableException extends ObjetException{

  public ObjetNonDeplacableException(){
    super();
  }

  public ObjetNonDeplacableException(String nomExp){
    super(nomExp);
  }
}
