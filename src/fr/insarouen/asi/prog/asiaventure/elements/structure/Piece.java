package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;

import java.util.Map;
import java.util.HashMap;

/**
 * Piece est une classe permettant de définir et d'utiliser les
 * différentes pièces du jeu.
 *
 * @author Anna Pineau, Alexis Melo da Silva
 */
public class Piece extends ElementStructurel {

  /**
   * Map de portes qui sont présentes dans la pièce
   *
   * @see Porte
   */
  private Map<String,Porte> tabPorte;

  /**
   * Map d'objets qui sont présentes dans la pièce
   *
   * @see Objet
   */
  private Map<String,Objet> tabObjet;

  /**
   * Map de vivants qui sont présentes dans la pièce
   *
   * @see Vivant
   */
  private Map<String,Vivant> tabVivant;



  /**
   * Constructeur Piece
   *
   * A la construction d'une piece, on lui attribue un nom,
   * et un monde. Elle peut par la suite posseder des potes, des objets et des vivants.
   *
   * @param nom
   *    Le nom de la piece
   * @param monde
   *    Le monde auquel appartient le vivant
   *
   * @see Monde
   *
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   */
  public Piece(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.tabPorte = new HashMap<>();
    this.tabObjet = new HashMap<>();
    this.tabVivant = new HashMap<>();
  }

  /**
   * Ajoute une Porte à la liste des portes de la pièce.
   *
   * @param porte Porte que l'on souhaite ajouter
   *
   * @see Porte
   */
   public void addPorte(Porte porte){
     this.tabPorte.put(porte.getNom(),porte);
   }


   /**
    * Vérifie si une Porte est présente dans la pièce.
    *
    * @param nomPorte Porte que l'on souhaite ajouter
    *
    *@return true si la porte est présente
    */
  public boolean aLaPorte(String nomPorte){
    return this.tabPorte.containsKey(nomPorte);
  }

  /**
   * Vérifie si une Porte est présente dans la pièce.
   *
   * @param Porte Porte que l'on souhaite ajouter
   * @see Porte
   *
   * @return true si la porte est présente
   */
  public boolean aLaPorte(Porte porte){
    return this.tabPorte.containsValue(porte);
  }



  /**
   * Vérifies si la pièce a bien l'objet
   *
   *@param nomObjet, objet dont la présence est vérifiée
   *
   *@return true si l'objet est dans la pièce
   */
  public boolean contientObjet(String nomObjet){
    return this.tabObjet.containsKey(nomObjet);
  }


  /**
   * Vérifies si la pièce a bien l'objet
   *
   *@param Objet, objet dont la présence est vérifiée
   *@see Objet
   *
   *@return true si l'objet est dans la pièce
   */
  public boolean contientObjet(Objet o){
    return this.tabObjet.containsValue(o);
  }


  /**
   * Vérifies si le vivant est bien dans la pièce
   *
   *@param nomVivant, vivant dont la présence est vérifiée
   *
   *@return true si le vivant est dans la pièce
   */
  public boolean contientVivant(String nomVivant){
    return this.tabVivant.containsKey(nomVivant);
  }


  /**
   * Vérifies si le vivant est bien dans la pièce
   *
   *@param v, vivant dont la présence est vérifiée
   *@see Vivant
   *
   *@return true si le vivant est dans la pièce
   */
  public boolean contientVivant(Vivant v){
    return this.tabVivant.containsValue(v);
  }


  /**
   *Ajoute un objet dans la pièce
   *
   *@param obj, obj qui va être ajouté à la liste d'objets de la pièce
   *@see Objet
   *
   */
  public void deposer(Objet obj){
    this.tabObjet.put(obj.getNom(),obj);
  }

  /**
   *Ajoute un vivant dans la pièce
   *
   *@param v, vivant qui va être ajouté à la liste des vivants de la pièce
   *@see Vivant
   *
   */
  public void entrer(Vivant v){
    this.tabVivant.put(v.getNom(),v);
  }



  /**
   * Obtient la liste des objets
   *
   * @return la Map d'objets
   */
  public Map<String,Objet> getObjets(){
    return this.tabObjet;
  }


  /**
   * Retourne la porte de la pièce dont le nom correspond
   *
   *@param nomPorte, le nom de la porte à retourner
   *
   * @return la porte
   */
  public Porte getPorte(String nomPorte){
    return this.tabPorte.get(nomPorte);
  }

  /**
   *Retire un objet dans la pièce et le retourne
   *
   *@param nomObj, nom de l'objet qui va être retiré à la liste d'objets de la pièce
   *
   *@return objet
   *
   *@exception ObjetAbsentDeLaPieceException
   *@exception ObjetNonDeplacableException
   */
  public Objet retirer(String nomObj) throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    Objet objRetire = this.tabObjet.get(nomObj);
    if (objRetire == null) {
      throw new ObjetAbsentDeLaPieceException();
    }
    if (!objRetire.estDeplacable()){
      throw new ObjetNonDeplacableException();
    }
      this.tabObjet.remove(nomObj);
    return objRetire;

  }

  /**
   *Retire un objet dans la pièce et le retourne
   *
   *@param o, objet qui va être retiré à la liste d'objets de la pièce
   *@see objet
   *
   *@return objet
   *@exception ObjetAbsentDeLaPieceException
   *@exception ObjetNonDeplacableException
   */
  public Objet retirer(Objet o) throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
   return retirer(o.getNom());
  }


  /**
   *Retire un vivant dans la pièce et le retourne
   *
   *@param nomVivant, nom du vivant qui va être retiré à la liste des vivants de la pièce
   *
   *@return Vivant
   *@exception VivantAbsentDeLaPieceException
   */
  public Vivant sortir(String nomVivant) throws VivantAbsentDeLaPieceException{
    Vivant vivRetire = this.tabVivant.get(nomVivant);
    if (vivRetire == null) {
      throw new VivantAbsentDeLaPieceException();
    }
      this.tabVivant.remove(nomVivant);
    return vivRetire;
  }

  /**
   *Retire un vivant dans la pièce et le retourne
   *
   *@param v, vivant qui va être retiré à la liste des vivants de la pièce
   *@see Vivant
   *
   *@return Vivant
   *@exception VivantAbsentDeLaPieceException
   */
  public Vivant sortir(Vivant v) throws VivantAbsentDeLaPieceException{
    return sortir(v.getNom());
  }


  /** Retourne sous forme de String les informations sur la pièce.
   *Donne ainsi le nombre et l'ensemble des objets, le nombre et l'ensemble des
   *vivants et le nombre et l'ensemble des portes.
   *
   *
   */
  public String toString(){
    StringBuilder EntiteStr = new StringBuilder();

    EntiteStr.append(String.format("La pièce possède %d objets : \n",this.tabObjet.size()));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabObjet));
    EntiteStr.append("\n");

    EntiteStr.append(String.format("La pièce possède %d portes : \n",this.tabPorte.size()));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabPorte));
    EntiteStr.append("\n");

    EntiteStr.append(String.format("La pièce possède %d vivants : \n",this.tabVivant.size()));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabVivant));
    EntiteStr.append("\n");

    return String.format("La pièce %s \n%s", this.getNom(), EntiteStr);
  }


}
