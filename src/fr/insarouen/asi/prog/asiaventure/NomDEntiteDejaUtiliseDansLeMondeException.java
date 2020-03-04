package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.MondeException;

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{

  public NomDEntiteDejaUtiliseDansLeMondeException(){
    super();
  }

  public NomDEntiteDejaUtiliseDansLeMondeException(String nomExp){
    super(nomExp);
  }
}
