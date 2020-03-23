package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;


public class Porte extends ElementStructurel implements Activable{


  private Piece pieceA;
  private Piece pieceB;
  private Serrure serrure;
  private Etat etat;

  /**
   * Constructeur Porte.
   *
   * A la construction d'une porte, un nom et un monde lui sont attribués, ainsi que les pi�ces qu'elle relie.
   * On suppose que par d�faut une porte est Ferm�e.
   * 
   * @param nom Nom de la porte
   * @param Monde monde dans lequel se trouve la porte
   * @param pieceA premi�re pi�ce o� se trouve la porte
   * @param pieceB seconde pi�ce o� se trouve la porte (adjacente � A)
   * @see ElementStructurel, Porte, Monde, Piece
   *
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Porte(String nom, Monde monde, Piece pieceA, Piece pieceB)  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    this.etat = Etat.FERME;
  }

  /**
   * Constructeur Porte.
   *
   * A la construction d'une porte, un nom et un monde lui sont attribués, ainsi que les pi�ces qu'elle relie.
   * On suppose que par d�faut une porte est Ferm�e.
   * 
   * @param nom Nom de la porte
   * @param Monde monde dans lequel se trouve la porte
   * @param pieceA premi�re pi�ce o� se trouve la porte
   * @param pieceB seconde pi�ce o� se trouve la porte (adjacente � A)
   * @param serrure Serrure pos�e sur la porte
   * 
   * @see ElementStructurel, Porte, Monde, Piece
   *
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Porte(String nom, Monde monde, Serrure serrure, Piece pieceA, Piece pieceB)  throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceA.addPorte(this);
    this.pieceB = pieceB;
    this.pieceB.addPorte(this);
    this.serrure = serrure;
    this.etat = Etat.FERME;
  }

  /**
   * Permet de savoir si une porte est activable avec un certain objet.
   * 
   * @param obj Objet avec lequel activer la porte
   * 
   * @see Objet
   */
  public boolean activableAvec(Objet obj){
    //à faire
    return true;
  }

  /**
   * Permet d'activer une porte. On peut activer seulement une porte ferm�e ou bien ouverte
   * pour la faire changer d'�tat.Lors de l'activation, une porte ferm�e deviens ouverte, et inversement.
   */
  public void activer() throws ActivationImpossibleException{
    if (this.etat.equals(Etat.VEROUILLE)) {
    	throw new ActivationImpossibleException();
    }
    else if (this.etat.equals(Etat.FERME)) {
      this.etat = Etat.OUVERT;
    }
    else if (this.etat.equals(Etat.OUVERT)) {
      this.etat = Etat.FERME;
    }
  }

  /**
   * Permet d'activer une porte avec un certain objet. On peut activer seulement une porte ferm�e ou bien ouverte
   * pour la faire changer d'�tat.Lors de l'activation, une porte ferm�e deviens ouverte, et inversement.
   *
   * @param obj Objet avec lequel on souhaite activer la porte
   * 
   * @see Objet
   */
  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
    //à faire
  }

  /*
   * Permet de connaitre l'�tat dans lequel se trouve la porte.
   * 
   * @see Etat
   */
  public Etat getEtat(){
    return this.etat;
  }

  /*
   * Permet d'obtenir la serrure pos�e sur la porte.
   * 
   * @see Serrure
   */
  public Serrure getSerrure(){
    return this.serrure;
  }

  /*
   * Permet de connaitre la pi�ce de l'autre c�t� de la porte, en partant d'une pi�ce
   * de r�f�rence. Retourne null si la pi�ce en param�tre ne correspond pas aux pi�ces
   * g�r�es par la porte.
   * 
   * @param piece Piece de d�part, dont on souhaite connaitre l'oppos�
   * 
   * @see Piece
   */
  public Piece getPieceAutreCote(Piece piece){
    if (piece.equals(this.pieceA)) {
      return this.pieceB;
    }
    if (piece.equals(this.pieceB)) {
      return this.pieceA;
    }
    return null;
  }

  public String toString(){
    return String.format("La porte %s relie les pièces %s et %s, elle est %s.", this.getNom(), this.pieceA.getNom(), this.pieceB.getNom(), this.etat.name());

  }
}
