package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ObjetException extends ASIAventureException{

  public ObjetException(){
    super();
  }

  public ObjetException(String nomExp){
    super(nomExp);
  }
}
