package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{

  public NomDEntiteDejaUtiliseDansLeMondeException(){
    super();
  }

  public NomDEntiteDejaUtiliseDansLeMondeException(String nomExp){
    super(nomExp);
  }
}
