package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.MondeException;

public class EntiteDejaDansUnAutreMondeException extends MondeException{
  public EntiteDejaDansUnAutreMondeException(){
    super();
  }

  public EntiteDejaDansUnAutreMondeException(String nomExp){
    super(nomExp);
  }
}
