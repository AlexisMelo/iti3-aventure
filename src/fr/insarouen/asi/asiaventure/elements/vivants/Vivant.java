package fr.insarouen.asi.asiaventure.elements.vivants;

import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;


public class Vivant extends Entite {

  private int pointVie;
  private int pointForce;
  private Piece piece;
  private Objet[] tabObjets;

  public Vivant(String nomElem,Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets){
    super(nomElem,monde);
    this.pointVie = pointVie;
    this.pointForce = pointForce;
    this.piece = piece;
    this.tabObjets = (Objet[])objets.clone();

    piece.entrer(this);
  }

  public void deposer(String nomObj){
    this.piece.deposer((Objet)Utilitaire.retirerEntite(nomObj, this.tabObjets));
  }

  public void deposer(Objet obj){
    deposer(obj.getNom());
  }

  public boolean estMort(){
    return this.pointVie == 0;
  }

  public Objet getObjet(String nomObj){
    for (Objet o : this.tabObjets) {
      if (o.getNom().equals(nomObj)) {
        return o;
      }
    }
    return null;
  }

  public Objet[] getObjets(){
    return this.tabObjets;
  }

  public Piece getPiece(){
    return this.piece;
  }

  public int getPointForce(){
    return this.pointForce;
  }

  public int getPointVie(){
    return this.pointVie;
  }

  public boolean possede(Objet obj){
    return Utilitaire.contientEntite(obj.getNom(), this.tabObjets);
  }

  public void prendre(String nomObj){
    Utilitaire.ajouterEntite(this.piece.retirer(nomObj), this.tabObjets);
  }

  public void prendre(Objet obj){
    prendre(obj.getNom());
  }


  public String toString(){
    StringBuilder EntiteStr = new StringBuilder();

    EntiteStr.append(String.format("Le vivant possède %d objets : \n",this.tabObjets.length));
    EntiteStr.append(Utilitaire.toStringTabEntite(this.tabObjets));
    EntiteStr.append("\n");

    return String.format("Le vivant %s est dans le monde %s.\n Il a %d points de vie et %d points de force. Il est dans la pièce %s avec les objets : %s.",this.getNom(),this.getMonde(),this.getPointVie(),this.getPointForce(),this.getPiece(),EntiteStr);
  }
}
