package fr.insarouen.asi.prog.asiaventure;

import java.lang.Exception;

public class ASIAventureException extends Exception{
  public ASIAventureException(){
    super();
  }

  public ASIAventureException(String nomExp){
    super(nomExp);
  }
}
