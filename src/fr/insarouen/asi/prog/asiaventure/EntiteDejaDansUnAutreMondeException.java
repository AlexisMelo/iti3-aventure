package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;

public class EntiteDejaDansUnAutreMondeException extends MondeException{
  public EntiteDejaDansUnAutreMondeException(){
    super();
  }

  public EntiteDejaDansUnAutreMondeException(String nomExp){
    super(nomExp);
  }
}
