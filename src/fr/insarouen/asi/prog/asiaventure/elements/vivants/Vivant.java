package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.HashMap;
import java.util.Map;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;

/**
 * Vivant est une classe permettant de d√©finir les vivants soient les personnages du jeu
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
   * La pi√®ce o√π se trouve le vivant
   *
   * @see Vivant#getPiece()
   */
  private Piece piece;

  /**
   * La liste des objets que poss√®de le viant.
   *
   * @see Vivant#getObjets()
   */
  private Map<String,Objet> tabObjets;

  /**
   * Constructeur Vivant.
   *
   * A la construction d'un vivant, on lui attribue un nom,
   * des points de vie et de force. On lui associe un monde et
   * une pi√®ce o√π il se trouve ainsi qu'une liste d'objets qu'il porte.
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
   *  La pi√®ce o√π il se trouve
   * @see Piece
   *
   * @param objets
   * La liste des objets que le vivant poss√®de
   * @see Objet
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Vivant(String nomElem,Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nomElem,monde);
    this.pointVie = pointVie;
    this.pointForce = pointForce;
    this.piece = piece;
    this.tabObjets = new HashMap<>();

    for(Objet o : objets){
      this.tabObjets.put(o.getNom(),o);
    }

    piece.entrer(this); // √† supprimer en fonction des prochains tp ??
  }

  /**
   * D√©pose l'objet correspondant au nom
   *
   *@param nomObjet nom de l'objet que l'on souhaite retirer du vivant
   *
   *@exception ObjetNonPossedeParLeVivantException
   */
  public void deposer(String nomObj)  throws ObjetNonPossedeParLeVivantException{
    Objet objRetire = getObjet(nomObj);
    if (objRetire == null) {
      throw new ObjetNonPossedeParLeVivantException();
    }
      this.tabObjets.remove(nomObj);
      this.piece.deposer(objRetire);

  }


  /**
   * D√©pose l'objet correspondant au nom
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
   * V√©rifies si le vivant est vivant
   *
   * @return true si le vivant est mort
   */
  public boolean estMort(){
    return this.pointVie == 0;
  }

  /**
   * Obtient l'objet correspondant au nom
   *
   *@param nomObjet nom de l'objet que l'on veut r√©cup√©rer
   *
   * @return objet
   */
  public Objet getObjet(String nomObj){
    return this.tabObjets.get(nomObj);
  }


  /**
   * Obtient la liste des objets
   *
   * @return le tableau d'objets
   */
  public Map<String,Objet> getObjets(){
    return this.tabObjets;
  }

  /**
   * Obtient la pi√®ce o√π est le vivant
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
   * V√©rifies si le vivant a l'objet
   *
   *@param objet objet dont la pr√©sence est v√©rifi√©e
   *@see Objet
   *
   *@return true si le vivant a l'objet
   */
  public boolean possede(Objet obj){
    return this.tabObjets.containsValue(obj);
  }


  /**
   * Ajoute l'objet s√©lectionn√© aux objets du vivant
   *
   *@param nomObj nom de l'objet que l'on veut prendre
   *
   *@exception ObjetAbsentDeLaPieceException
   *@exception ObjetNonDeplacableException
   */
  public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
    Objet objRetire = this.piece.retirer(nomObj);
    this.tabObjets.put(objRetire.getNom(),objRetire);
  }


  /**
   * Ajoute l'objet s√©lectionn√© aux objets du vivant
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

  /**
   * Permet ‡ un vivant de traverser une porte. La piËce dans laquelle se
   * trouve le vivant deviens la piËce opposÈe de la porte.
   *
   *@param porte Porte ‡ traverser
   *@see Porte
   *
   *@exception PorteFermeException
   *@exception PorteInexistanteDansLaPieceException
   */
  public void franchir(Porte porte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
      franchir(porte.getNom());
  }

  /**
   * Permet ‡ un vivant de traverser une porte. La piËce dans laquelle se
   * trouve le vivant deviens la piËce opposÈe de la porte.
   *
   *@param nomPorte Nom de la porte ‡ traverser
   *@see Porte
   *
   *@exception PorteFermeException
   *@exception PorteInexistanteDansLaPieceException
   */
  public void franchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
    if(!this.piece.aLaPorte(nomPorte)) {
      throw new PorteInexistanteDansLaPieceException();
    }

    Porte porteAFranchir = this.piece.getPorte(nomPorte);
    if(porteAFranchir.getEtat().equals(Etat.FERME)){
      throw new PorteFermeException();
    }

    this.piece = porteAFranchir.getPieceAutreCote(this.piece);
  }

  /**
   * Permet d'activer un objet de type Activable (porte, coffres, ...).
   * LËve des exceptions quand les conditions d'activation ne sont pas remplies
   * 
   *@param activable Element ‡ activer
   *@see Activable
   *
   *@exception ActivationException
   */
  public void activerActivable(Activable activable) throws ActivationException {
    activable.activer();
  }

  /**
   * Permet d'activer un objet de type Activable (porte, coffres, ...) avec un objet donnÈ.
   * LËve des exceptions quand les conditions d'activation ne sont pas remplies
   * 
   *@param activable Element ‡ activer
   *@param objet Objet avec lequel activer l'Èlement activable
   *@see Activable
   *@see Objet
   *
   *@exception ActivationException
   */
  public void activerActivableAvecObjet(Activable activable, Objet objet) throws ActivationException {
    activable.activerAvec(objet);
  }

  /** Retourne sous forme de String les informations sur le vivant.
   *Donne le nom du vivant ainsi que son monde, ses points de vie et de force,
   *sa pi√®ce et ses objets.
   *
   *
   */
  public String toString(){
    StringBuilder EntiteStr = new StringBuilder();

    EntiteStr.append(String.format("%s poss√®de %d objets : \n",this.getNom(),this.tabObjets.size()));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabObjets));
    EntiteStr.append("\n");

    return String.format("Le vivant %s est dans le monde %s.\n Il a %d points de vie et %d points de force.\n Il est dans la pi√®ce %s.\n %s.",this.getNom(),this.getMonde().getNom(),this.getPointVie(),this.getPointForce(),this.getPiece().getNom(),EntiteStr);
  }
}
