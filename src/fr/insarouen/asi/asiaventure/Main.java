package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.Monde;

public class Main{
  public static void main(String[] args) {

        Monde monde1 = new Monde("LaVie");
        System.out.printf("Le monde s'apelle %s.\n",monde1.getNom());

//test 1 : Ajout d'objet dans le monde et "lecture" du monde.
        Objet objUtile = new Objet("fourchette",monde1);
        System.out.printf("On ajoute l'objet %s.\n",objUtile.getNom());

        Objet objpasUtile = new Objet("coursDElec",monde1);
      System.out.printf("On ajoute l'objet %s.\n",objpasUtile.getNom());

        System.out.printf("%s\n",monde1.toString());

//test 2 : egalité de deux mondes avec le même objet.
        Objet objUtile2 = new Objet("fourchette",monde1);

        System.out.printf("Les objets %s et %s sont-ils égaux?\n",objUtile.getNom(),objUtile2.getNom());
        System.out.println(objUtile.equals(objUtile2));


  }
}
