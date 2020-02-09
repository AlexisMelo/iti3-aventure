package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;

public class TestObjet {

    public Monde monde = new Monde("Rouen");
    public Objet obj = new Objet("Objet n°1",this.monde){
      public boolean estDeplacable() {
        return true;
      }
    };

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
    }

    @Test
    public void test_estDeplacable() {
      //test inutile mais j'ai pas compris le sujet de TP qui dit de refaire nos tests
      assertTrue(this.obj.estDeplacable());
    }

}
