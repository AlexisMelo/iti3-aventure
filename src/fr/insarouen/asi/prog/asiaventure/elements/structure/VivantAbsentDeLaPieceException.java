package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class VivantAbsentDeLaPieceException extends PieceException{

  public VivantAbsentDeLaPieceException(){
    super();
  }

  public VivantAbsentDeLaPieceException(String nomExp){
    super(nomExp);
  }
}
