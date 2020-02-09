package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.Entite;

public class TestEntite{

  public Monde monde = new Monde("Rouen");
  public Entite entite = new Entite("Elève à l'INSA",this.monde){};

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
      System.out.println("Testing class Entite");
      this.printClassBeingTested = false;
    }
    if(this.printObjectToString) {
      System.out.println(this.entite);
      this.printObjectToString = false;
    }
  }

  @Test
  public void test_getNom() {
    assertEquals(this.entite.getNom(), "Elève à l'INSA");
  }

  @Test
  public void test_getMonde() {
    assertEquals(this.entite.getMonde(), this.monde);
  }

  @Test
  public void test_equals() {
    Entite entite2 = new Entite("Elève à l'INSA",this.monde){};
    assertTrue(entite2.equals(this.entite));
  }

  @Test
  public void test_hashcode() {
    Entite entite2 = new Entite("Elève à l'INSA",this.monde){};
    assertEquals(this.entite.hashCode(), entite2.hashCode());
  }


}
