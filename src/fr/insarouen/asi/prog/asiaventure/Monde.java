
package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.asiaventure.EntiteDejaDansUnAutreMondeException;


/**
 * Monde est une classe représentant l'environnement dans lequel se déroule le jeu.
 * Il est composé d'une multitude d'entités uniques.
 *
 * @author Anna Pineau, Alexis Melo da Silva
 *
 * @see Entite
 */
public class Monde{

  /**
   * Tableau d'entités qui sont présentes dans le monde
   *
   * @see Entite
   */
  private Entite[] tabEntite;

  /**
   * Nom du monde
   */
  private String nom;

  /**
   * Constructeur Monde.
   *
   * A la construction du monde un nom lui est attribué et il ne comporte aucune
   * entité.
   *
   * @see Entite
   */
  public Monde(String nomMonde){
    this.nom = nomMonde;
    this.tabEntite = new Entite[0];
  }

  /**
   * Obtient le nom du monde
   *
   * @return Nom du monde
   */
  public String getNom(){
    return this.nom;
  }

  /**
   * Obtient un objet entité à partir de son nom, null si l'entité n'est pas trouvée.
   *
   * @param nomEntite nom de l'entité cherchée dans le monde
   *
   * @return Entité correspondante, null si non trouvée.
   *
   * @see Entite
   */
  public Entite getEntite(String nomEntite){
    for (Entite e : this.tabEntite) {
      if (e.getNom().equals(nomEntite)) {
        return e;
      }
    }
    return null;
  }

  /**
   * Ajoute une entité à la liste des entités du monde.
   *
   * @param e Entité que l'on souhaite ajouter
   *
   * @see Entite
   *
   *@exception NomDEntiteDejaUtiliseDansLeMondeException
   *@exception EntiteDejaDansUnAutreMondeException
   */
  public void ajouter(Entite e) throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException {
    if(!(this.getEntite(e.getNom()) == null)) {
        throw new NomDEntiteDejaUtiliseDansLeMondeException();
    }
    if(!(this.equals(e.getMonde()))) {
      throw new EntiteDejaDansUnAutreMondeException(String.format("L'entité est déjà dans le monde : %s", e.getMonde().getNom()));
    }
    Entite[] tabEntite2 = new Entite[this.tabEntite.length+1];
    for (int i = 0; i< this.tabEntite.length; i++) {
      tabEntite2[i] = tabEntite[i];
    }
    tabEntite2[tabEntite2.length-1] = e;
    this.tabEntite = tabEntite2;


  }

  /**
   * Retourne sous forme de String les informations sur le monde. Le String
   * comporte le nom de toutes les entités du monde ainsi que le nom du monde.
   *
   * @return String donnant des informations sur l'entité
   *
   * @see Entite
   */
  public String toString(){
    StringBuilder EntiteStr = new StringBuilder();
    for (int i = 0; i< this.tabEntite.length;i++){
      EntiteStr.append(this.tabEntite[i].getNom());
      EntiteStr.append(", ");
    }
    EntiteStr.delete(EntiteStr.length()-2,EntiteStr.length());
    return String.format("Le monde %s possède les entites %s.", this.nom, EntiteStr);
  }
}
