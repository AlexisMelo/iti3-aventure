package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;


/**
 * Monde est une classe représentant l'environnement dans lequel se déroule le jeu.
 * Il est composé d'une multitude d'entités uniques.
 *
 * @author Anna Pineau, Alexis Melo da Silva
 *
 * @see Entite
 */
public class Monde implements Serializable{

  /**
   * Map d'entités qui sont présentes dans le monde
   *
   * @see Entite
   */
  private Map<String,Entite> tabEntite;

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
    this.tabEntite = new HashMap<>();
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
    return this.tabEntite.get(nomEntite);
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
    this.tabEntite.put(e.getNom(),e);
  }


  public Collection<Executable> getExecutables() {
	List<Executable> tabExecutable = new ArrayList<Executable>();
    for ( Entite e : this.tabEntite.values()) {
      if (e instanceof Executable){
    	  tabExecutable.add((Executable)e);
      }
    }
    return tabExecutable; 
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
    return String.format("Le monde %s", this.nom);
  }
}
