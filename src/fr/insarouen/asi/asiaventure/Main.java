package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.Monde;

public class Main{
  public static void main(String[] args) {

        Monde monde1 = new Monde("LaVie");
        Objet objUtile = new Objet("fourchette",monde1);
        Objet objpasUtile = new Objet("coursDElec",monde1);

        System.out.print(monde1);
  }
}
