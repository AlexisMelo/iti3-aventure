package fr.insarouen.asi.prog.asiaventure;

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{

  public NomDEntiteDejaUtiliseDansLeMondeException(){
    super();
  }

  public NomDEntiteDejaUtiliseDansLeMondeException(String nomExp){
    super(nomExp);
  }
}
