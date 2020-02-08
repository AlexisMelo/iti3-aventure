package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.Entite;

public class TestEntite{

  public Entite entite;

  @Before
  public void init() {

    Monde rouen = new Monde("Rouen");
    this.entite = new Entite("Elève à l'INSA",rouen){};

  }

  @Test
  public void test_getNom() {
    assertEquals(this.entite.getNom(), "Elve à l'INSA");
  }


}
