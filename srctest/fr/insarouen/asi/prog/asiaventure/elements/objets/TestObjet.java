package fr.insarouen.asi.asiaventure.elements.objets;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;

public class TestObjet {

    public Monde monde;
    public Objet obj;

    /**
     * Mettre à true si on veut afficher que la classe est entrain d'être testée
     */
    public static boolean printClassBeingTested = true;

    /**
     * Mettre à true si on veut afficher un exemple de toString de la classe testée
     */
    public static boolean printObjectToString = false;

    @Before
    public void init() {
      if(this.printClassBeingTested) {
        System.out.println("Testing class Objet");
        this.printClassBeingTested = false;
      }
      if(this.printObjectToString) {
        System.out.println(this.obj);
        this.printObjectToString = false;
      }

      try {
        this.monde = new Monde("Rouen");
        this.obj = new Objet("Objet n°1",this.monde){
          public boolean estDeplacable() {
            return true;
          }
        };
      } catch (Exception e) {
        System.out.println(e);
      }

    }

    @Test
    public void test_estDeplacable() {
      //test inutile mais j'ai pas compris le sujet de TP qui dit de refaire nos tests
      assertThat(this.obj.estDeplacable(),is(true));
    }

}
