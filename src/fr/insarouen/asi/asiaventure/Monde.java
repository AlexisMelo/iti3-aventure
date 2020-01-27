package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.elements.Entite;


public class Monde{
  private final static int nbEntite = 10;
 private Entite[] tabEntite;
 private String nom;

  public Monde(String str){
    this.nom = str;
    this.tabEntite = new Entite[nbEntite];
  }
}
