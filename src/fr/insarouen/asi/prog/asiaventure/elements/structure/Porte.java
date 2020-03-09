package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;


public class Porte extends ElementStructurel implements Activable{


  private Piece pieceA;
  private Piece pieceB;
  private Serrure serrure;
  private Etat etat;

  /**
   * Constructeur Porte.
   *
   * A la construction d'une porte, un nom et un monde lui sont attribués.
   *
   * @see ElementStructurel
   *
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Porte(String nom, Monde monde, Piece pieceA, Piece pieceB)  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    this.etat = Etat.FERME;
  }

  public Porte(String nom, Monde monde, Serrure serrure, Piece pieceA, Piece pieceB)  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    this.serrure = serrure;
    this.etat = Etat.FERME;
  }

  public boolean activableAvec(Objet obj){
    //à faire
    return true;
  }

  public void activer(){
    //à modifier
    if (this.etat.equals(Etat.FERME)) {
      this.etat = Etat.OUVERT;
    }
    else if (this.etat.equals(Etat.OUVERT)) {
      this.etat = Etat.FERME;
    }
  }

  public void activerAvec(Objet obj){
    //à faire
  }

  public Etat getEtat(){
    return this.etat;
  }

  public Serrure getSerrure(){
    return this.serrure;
  }

  public Piece getPieceAutreCote(Piece piece){
    if (this.pieceA.equals(piece)) {
      return this.pieceB;
    }
    return this.pieceA;
  }

  public String toString(){
    return String.format("La porte %s relie les pièces %s et %s, elle est %s.", this.getNom(), this.pieceA.getNom(), this.pieceB.getNom(), this.etat.name());

  }
}
