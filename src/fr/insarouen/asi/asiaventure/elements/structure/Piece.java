package fr.insarouen.asi.asiaventure.elements.structure;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.elements.vivants.Vivant;


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
   */
  public Piece(String nom, Monde monde){
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
  protected void addPorte(Porte porte){
     Utilitaire.ajouterEntite(porte,this.tabPorte);
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



  public boolean contientObjet(String nomObjet){
    return Utilitaire.contientEntite(nomObjet,this.tabObjet);
  }


  public boolean contientObjet(Objet o){
    return contientObjet(o.getNom());
  }

  public boolean contientVivant(String nomVivant){
    return Utilitaire.contientEntite(nomVivant,this.tabVivant);
  }


  public boolean contientVivant(Vivant v){
    return contientVivant(v.getNom());
  }

  public void deposer(Objet obj){
    Utilitaire.ajouterEntite(obj,this.tabObjet);
  }

  public void entrer(Vivant v){
    Utilitaire.ajouterEntite(v,this.tabVivant);
  }

  public Objet[] getObjets(){
    return this.tabObjet;
  }

  public Porte getPorte(String nomPorte){
    for (Porte p : this.tabPorte) {
      if (p.getNom().equals(nomPorte)) {
        return p;
      }
    }
    return null;
  }

  public Objet retirer(String o){
    return (Objet) Utilitaire.retirerEntite(o,this.tabObjet);
  }

  public Objet retirer(Objet o){
   return retirer(o.getNom());
  }

  public Vivant sortir(String v){
    return (Vivant) Utilitaire.retirerEntite(v,this.tabVivant);
  }

  public Vivant sortir(Vivant v){
    return sortir(v.getNom());
  }

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

    return String.format("La pièce %s \n %s", this.getNom(), EntiteStr);
  }


}
