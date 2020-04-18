package fr.insarouen.asi.prog.asiaventure.elements.vivants;

public class CommandeImpossiblePourLeVivantException extends VivantException{

  public CommandeImpossiblePourLeVivantException(){
    super();
  }

  public CommandeImpossiblePourLeVivantException(String nomExp){
    super(nomExp);
  }
}
