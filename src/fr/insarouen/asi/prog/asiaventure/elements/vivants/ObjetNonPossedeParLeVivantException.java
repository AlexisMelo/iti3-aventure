package fr.insarouen.asi.prog.asiaventure.elements.vivants;

public class ObjetNonPossedeParLeVivantException extends VivantException{

  public ObjetNonPossedeParLeVivantException(){
    super();
  }

  public ObjetNonPossedeParLeVivantException(String nomExp){
    super(nomExp);
  }
}
