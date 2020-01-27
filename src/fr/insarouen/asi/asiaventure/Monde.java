package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.elements.Entite;


public class Monde{

 private Entite[] tabEntite;
 private String nom;

  public Monde(String nomMonde){
    this.nom = nomMonde;
    this.tabEntite = new Entite[1];
  }

  public String getNom(){
    return this.nom;
  }

  public Entite getEntite(String nomEntite){
    for (Entite e : this.tabEntite) {
      if (e.getNom().equals(nomEntite)) {
        return e;
      }
    }
    return null;
  }

  public void ajouter(Entite e){
    Entite[] tabEntite2 = new Entite[this.tabEntite.length+1];
    for (int i = 0; i< this.tabEntite.length; i++) {
      tabEntite2[i] = tabEntite[i];
    }
    tabEntite2[tabEntite2.length-1] = e;
    this.tabEntite = tabEntite2;
  }

  public String toString(){
    return String.format("Le monde %s a les entites %s", this.nom, java.util.Arrays.toString(this.tabEntite));
  }
}
