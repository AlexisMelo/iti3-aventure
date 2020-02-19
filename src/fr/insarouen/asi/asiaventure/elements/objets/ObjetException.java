package fr.insarouen.asi.asiaventure.elements.objets;

import fr.insarouen.asi.asiaventure.ASIAventureException;

public class ObjetException extends ASIAventureException{

  public ObjetException(){
    super();
  }

  public ObjetException(String nomExp){
    super(nomExp);
  }
}
