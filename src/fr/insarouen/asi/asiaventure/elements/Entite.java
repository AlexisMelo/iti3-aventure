package fr.insarouen.asi.asiaventure.elements;

import fr.insarouen.asi.asiaventure.Monde;

public class Entite {

  private String nom;
  private Monde monde;

  public Entite(String nom,Monde monde){
    this.nom = nom;
    this.monde = monde;
    this.monde.ajouter(this);
  }

  public String getNom(){
    return this.nom;
  }

  public Monde getMonde(){
    return this.monde;
  }

  public String toString(){
    return String.format("L'entite %s est dans le monde %s",this.nom,this.monde);
  }

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
