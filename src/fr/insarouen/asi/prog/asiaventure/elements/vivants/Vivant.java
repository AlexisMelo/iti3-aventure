package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;

import java.util.Arrays;

/**
 * Vivant est une classe permettant de définir les vivants soient les personnages du jeu
 *
 * @author Anna Pineau, Alexis Melo da Silva
 */
public class Vivant extends Entite {


  /**
   * Le nombre de points de vie.
   *
   * @see Vivant#getPointVie()
   */
  private int pointVie;


  /**
   * Le nombre de points de force.
   *
   * @see Vivant#getPointForce()
   */
  private int pointForce;

  /**
   * La pièce où se trouve le vivant
   *
   * @see Vivant#getPiece()
   */
  private Piece piece;

  /**
   * La liste des objets que possède le viant.
   *
   * @see Vivant#getObjets()
   */
  private Objet[] tabObjets;

  /**
   * Constructeur Vivant.
   *
   * A la construction d'un vivant, on lui attribue un nom,
   * des points de vie et de force. On lui associe un monde et
   * une pièce où il se trouve ainsi qu'une liste d'objets qu'il porte.
   *
   * @param nomElem
   *    Le nom du vivant
   * @param monde
   *    Le monde auquel appartient le vivant
   *
   * @see Monde
   *
   * @param pointVie
   *  Le nombre de point de vie
   *
   * @param pointForce
   *  Le nombre de point de force
   *
   * @param piece
   *  La pièce où il se trouve
   * @see Piece
   *
   * @param objets
   * La liste des objets que le vivant possède
   * @see Objet
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Vivant(String nomElem,Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nomElem,monde);
    this.pointVie = pointVie;
    this.pointForce = pointForce;
    this.piece = piece;
    this.tabObjets = (Objet[])objets.clone();

    piece.entrer(this); // à supprimer en fonction des prochains tp ??
  }

  /**
   * Dépose l'objet correspondant au nom
   *
   *@param nomObjet nom de l'objet que l'on souhaite retirer du vivant
   *
   *@exception ObjetNonPossedeParLeVivantException
   */
  public void deposer(String nomObj)  throws ObjetNonPossedeParLeVivantException{
    Objet objRetire = (Objet) Utilitaire.obtenirEntite(nomObj, this.tabObjets);
    if (objRetire == null) {
      throw new ObjetNonPossedeParLeVivantException();
    }
      Entite[] newTab = Utilitaire.retirerEntite(objRetire.getNom(),this.tabObjets);
      this.tabObjets = Arrays.copyOf(newTab, newTab.length, Objet[].class);
      this.piece.deposer(objRetire);

  }


  /**
   * Dépose l'objet correspondant au nom
   *
   *@param objet objet que l'on souhaite retirer du vivant
   *
   *@see Objet
   *
   *@exception ObjetNonPossedeParLeVivantException
   */
  public void deposer(Objet obj) throws ObjetNonPossedeParLeVivantException{
    deposer(obj.getNom());
  }


  /**
   * Vérifies si le vivant est vivant
   *
   * @return true si le vivant est mort
   */
  public boolean estMort(){
    return this.pointVie == 0;
  }

  /**
   * Obtient l'objet correspondant au nom
   *
   *@param nomObjet nom de l'objet que l'on veut récupérer
   *
   * @return objet
   */
  public Objet getObjet(String nomObj){
    for (Objet o : this.tabObjets) {
      if (o.getNom().equals(nomObj)) {
        return o;
      }
    }
    return null;
  }


  /**
   * Obtient la liste des objets
   *
   * @return le tableau d'objets
   */
  public Objet[] getObjets(){
    return this.tabObjets;
  }

  /**
   * Obtient la pièce où est le vivant
   *
   *
   *
   * @return Piece
   *@see Piece
   */
  public Piece getPiece(){
    return this.piece;
  }


  /**
   * Obtient les points de force du vivant
   *
   *
   *
   * @return les points de force
   */
  public int getPointForce(){
    return this.pointForce;
  }


  /**
   * Obtient les points de vie du vivant
   *
   *
   *
   * @return les points de vie
   */
  public int getPointVie(){
    return this.pointVie;
  }


  /**
   * Vérifies si le vivant a l'objet
   *
   *@param objet objet dont la présence est vérifiée
   *@see Objet
   *
   *@return true si le vivant a l'objet
   */
  public boolean possede(Objet obj){
    return Utilitaire.contientEntite(obj.getNom(), this.tabObjets);
  }


  /**
   * Ajoute l'objet sélectionné aux objets du vivant
   *
   *@param nomObj nom de l'objet que l'on veut prendre
   *
   *@exception ObjetAbsentDeLaPieceException
   *@exception ObjetNonDeplacableException
   */
  public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
    Objet objRetire = this.piece.retirer(nomObj);
    Entite[] newTab = Utilitaire.ajouterEntite(objRetire,this.tabObjets);
    this.tabObjets = Arrays.copyOf(newTab, newTab.length, Objet[].class);
  }


  /**
   * Ajoute l'objet sélectionné aux objets du vivant
   *
   *@param objet objet que l'on veut prendre
   *@see Objet
   *
   *@exception ObjetAbsentDeLaPieceException
   *@exception ObjetNonDeplacableException
   */
  public void prendre(Objet obj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    prendre(obj.getNom());
  }

  /** Retourne sous forme de String les informations sur le vivant.
   *Donne le nom du vivant ainsi que son monde, ses points de vie et de force,
   *sa pièce et ses objets.
   *
   *
   */
  public String toString(){
    StringBuilder EntiteStr = new StringBuilder();

    EntiteStr.append(String.format("%s possède %d objets : \n",this.getNom(),this.tabObjets.length));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabObjets));
    EntiteStr.append("\n");

    return String.format("Le vivant %s est dans le monde %s.\n Il a %d points de vie et %d points de force.\n Il est dans la pièce %s.\n %s.",this.getNom(),this.getMonde().getNom(),this.getPointVie(),this.getPointForce(),this.getPiece().getNom(),EntiteStr);
  }
}
