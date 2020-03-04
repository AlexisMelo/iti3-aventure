package fr.insarouen.asi.asiaventure.elements.structure;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;

import java.util.Arrays;

/**
 * Piece est une classe permettant de définir et d'utiliser les
 * différentes pièces du jeu.
 *
 * @author Anna Pineau, Alexis Melo da Silva
 */
public class Piece extends ElementStructurel {

  /**
   * Tableau de portes qui sont présentes dans la pièce
   *
   * @see Porte
   */
  private Porte[] tabPorte;

  /**
   * Tableau d'objets qui sont présentes dans la pièce
   *
   * @see Objet
   */
  private Objet[] tabObjet;

  /**
   * Tableau de vivants qui sont présentes dans la pièce
   *
   * @see Vivant
   */
  private Vivant[] tabVivant;



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
    this.tabPorte = new Porte[0];
    this.tabObjet = new Objet[0];
    this.tabVivant = new Vivant[0];
  }

  /**
   * Ajoute une Porte à la liste des portes de la pièce.
   *
   * @param porte Porte que l'on souhaite ajouter
   *
   * @see Porte
   */
   public void addPorte(Porte porte){
     Entite[] newTab = Utilitaire.ajouterEntite(porte,this.tabPorte);
     this.tabPorte = Arrays.copyOf(newTab, newTab.length, Porte[].class);
   }


   /**
    * Vérifie si une Porte est présente dans la pièce.
    *
    * @param nomPorte Porte que l'on souhaite ajouter
    *
    *@return true si la porte est présente
    */
  public boolean aLaPorte(String nomPorte){
    return Utilitaire.contientEntite(nomPorte,this.tabPorte);
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
    return aLaPorte(porte.getNom());
  }



  /**
   * Vérifies si la pièce a bien l'objet
   *
   *@param nomObjet, objet dont la présence est vérifiée
   *
   *@return true si l'objet est dans la pièce
   */
  public boolean contientObjet(String nomObjet){
    return Utilitaire.contientEntite(nomObjet,this.tabObjet);
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
    return contientObjet(o.getNom());
  }


  /**
   * Vérifies si le vivant est bien dans la pièce
   *
   *@param nomVivant, vivant dont la présence est vérifiée
   *
   *@return true si le vivant est dans la pièce
   */
  public boolean contientVivant(String nomVivant){
    return Utilitaire.contientEntite(nomVivant,this.tabVivant);
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
    return contientVivant(v.getNom());
  }


  /**
   *Ajoute un objet dans la pièce
   *
   *@param obj, obj qui va être ajouté à la liste d'objets de la pièce
   *@see Objet
   *
   */
  public void deposer(Objet obj){
    Entite[] newTab = Utilitaire.ajouterEntite(obj,this.tabObjet);
    this.tabObjet = Arrays.copyOf(newTab, newTab.length, Objet[].class);
  }

  /**
   *Ajoute un vivant dans la pièce
   *
   *@param v, vivant qui va être ajouté à la liste des vivants de la pièce
   *@see Vivant
   *
   */
  public void entrer(Vivant v){
    Entite[] newTab = Utilitaire.ajouterEntite(v,this.tabVivant);
    this.tabVivant = Arrays.copyOf(newTab, newTab.length, Vivant[].class);
  }



  /**
   * Obtient la liste des objets
   *
   * @return le tableau d'objets
   */
  public Objet[] getObjets(){
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
    for (Porte p : this.tabPorte) {
      if (p.getNom().equals(nomPorte)) {
        return p;
      }
    }
    return null;
  }

  /**
   *Retire un objet dans la pièce et le retourne
   *
   *@param o, nom de l'objet qui va être retiré à la liste d'objets de la pièce
   *
   *@return objet
   *
   *@exception ObjetAbsentDeLaPieceException
   *@exception ObjetNonDeplacableException
   */
  public Objet retirer(String o) throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    Objet objRetire = (Objet) Utilitaire.obtenirEntite(o, this.tabObjet);
    if (objRetire == null) {
      throw new ObjetAbsentDeLaPieceException();
    }
    if (!objRetire.estDeplacable()){
      throw new ObjetNonDeplacableException();
    }
      Entite[] newTab = Utilitaire.retirerEntite(o,this.tabObjet);
      this.tabObjet = Arrays.copyOf(newTab, newTab.length, Objet[].class);
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
   *@param v, nom du vivant qui va être retiré à la liste des vivants de la pièce
   *
   *@return Vivant
   *@exception VivantAbsentDeLaPieceException
   */
  public Vivant sortir(String v) throws VivantAbsentDeLaPieceException{
    Vivant vivRetire = (Vivant) Utilitaire.obtenirEntite(v, this.tabVivant);
    if (vivRetire == null) {
      throw new VivantAbsentDeLaPieceException();
    }
      Entite[] newTab = Utilitaire.retirerEntite(v,this.tabVivant);
      this.tabVivant = Arrays.copyOf(newTab, newTab.length, Vivant[].class);
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

    EntiteStr.append(String.format("La pièce possède %d objets : \n",this.tabObjet.length));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabObjet));
    EntiteStr.append("\n");

    EntiteStr.append(String.format("La pièce possède %d portes : \n",this.tabPorte.length));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabPorte));
    EntiteStr.append("\n");

    EntiteStr.append(String.format("La pièce possède %d vivants : \n",this.tabVivant.length));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabVivant));
    EntiteStr.append("\n");

    return String.format("La pièce %s \n%s", this.getNom(), EntiteStr);
  }


}
