package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

public class ObjetNonPossedeParLeVivantException extends VivantException{

  public ObjetNonPossedeParLeVivantException(){
    super();
  }

  public ObjetNonPossedeParLeVivantException(String nomExp){
    super(nomExp);
  }
}
