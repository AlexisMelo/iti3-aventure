package fr.insarouen.asi.asiaventure.elements.structure;

import fr.insarouen.asi.asiaventure.elements.structure.PieceException;

public class ObjetAbsentDeLaPieceException extends PieceException{

  public ObjetAbsentDeLaPieceException(){
    super();
  }

  public ObjetAbsentDeLaPieceException(String nomExp){
    super(nomExp);
  }
}
