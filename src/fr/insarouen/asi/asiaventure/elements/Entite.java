package fr.insarouen.asi.asiaventure.elements;

import fr.insarouen.asi.asiaventure.Monde;

/**
 * Entite est une classe permettant de définir les élements de base pour la création
 * des composants du jeu (Objets, Elements structurels, Vivants, ...)
 *
 * @author Anna Pineau, Alexis Melo da Silva
 */
public abstract class Entite {

  /**
   * Le nom de l'entité.
   *
   * @see Entite#getNom()
   */
  private String nom;

  /**
   * Le monde auquel appartient l'entité.
   *
   * @see Entite#getMonde()
   */
  private Monde monde;

  /**
   * Constructeur Entite.
   *
   * A la construction d'une entité, on lui attribue un monde auquel elle appartient
   * et un nom. On considère qu'une entité appartient à un seul monde.
   *
   * @param nomEntite
   *    Le nom de l'entite
   * @param monde
   *    Le monde auquel appartient l'entité
   *
   * @see Monde
   */
  public Entite(String nomEntite,Monde monde){
    this.nom = nomEntite;
    this.monde = monde;
    this.monde.ajouter(this);
  }

  /**
   * Obtient le nom de l'entité
   *
   * @return Nom de l'entité
   */
  public String getNom(){
    return this.nom;
  }

  /**
   * Obtient le monde auquel appartient l'entité
   *
   * @return Monde dans lequel est l'entité
   *
   * @see Monde
   */
  public Monde getMonde(){
    return this.monde;
  }

  /**
   * Retourne sous forme de String les informations sur l'entité. Le String
   * comporte les informations sur le monde et le nom de l'entité
   *
   * @return String donnant des informations sur l'entité
   */
  public String toString(){
    return String.format("L'entite %s est dans le monde %s",this.nom,this.monde);
  }

  /**
   * Vérifie l'égalité entre deux entités. L'égalité dépend du nom de l'éntité
   * et du monde auquel elle appartient
   *
   * @return Vrai si les entités sont égales, faux sinon
   *
   * @see Monde
   */
  public boolean equals(Object o){
    if (o==this){
      return true;
    }
    if ((o==null) || this.getClass() != o.getClass()){
      return false;
    }
    Entite entiteO = (Entite) o;
    if (!entiteO.getNom().equals(this.nom)){
      return false;
    }
    if (!entiteO.getMonde().equals(this.monde)){
      return false;
    }
      return true;
  }

  public int hashCode(){
    return 13*this.nom.hashCode() + 17*this.monde.hashCode();
  }
}
