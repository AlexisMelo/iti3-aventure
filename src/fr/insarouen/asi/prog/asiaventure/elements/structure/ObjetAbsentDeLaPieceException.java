package fr.insarouen.asi.prog.asiaventure.elements.structure;

public class ObjetAbsentDeLaPieceException extends PieceException{

  public ObjetAbsentDeLaPieceException(){
    super();
  }

  public ObjetAbsentDeLaPieceException(String nomExp){
    super(nomExp);
  }
}
