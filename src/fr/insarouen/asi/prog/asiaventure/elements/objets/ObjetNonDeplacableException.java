package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;

public class ObjetNonDeplacableException extends ObjetException{

  public ObjetNonDeplacableException(){
    super();
  }

  public ObjetNonDeplacableException(String nomExp){
    super(nomExp);
  }
}
