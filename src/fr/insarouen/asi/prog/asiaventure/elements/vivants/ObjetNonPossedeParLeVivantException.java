package fr.insarouen.asi.asiaventure.elements.vivants;

import fr.insarouen.asi.asiaventure.elements.vivants.VivantException;

public class ObjetNonPossedeParLeVivantException extends VivantException{

  public ObjetNonPossedeParLeVivantException(){
    super();
  }

  public ObjetNonPossedeParLeVivantException(String nomExp){
    super(nomExp);
  }
}
