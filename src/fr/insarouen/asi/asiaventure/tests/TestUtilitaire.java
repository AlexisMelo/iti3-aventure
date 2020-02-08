package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import fr.insarouen.asi.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.Monde;


public class TestUtilitaire {

    /**
     * Mettre à true si on veut afficher que la classe est entrain d'être testée
     */
    public static boolean printClassBeingTested = true;

    @Before
    public void init() {
      if(this.printClassBeingTested) {
        System.out.println("Testing class Utilitaire");
        this.printClassBeingTested = false;
      }
    }

    @Test
    public void test_ajoutEntite() {

      Entite e = new Entite("entite 1", new Monde("monde1")){};
      Entite[] tabE = new Entite[0];

      assertEquals(0, tabE.length);
      tabE = Utilitaire.ajouterEntite(e, tabE);

      assertEquals(1, tabE.length);

      boolean trouve = false;

      for (Entite en : tabE) {
        if (en.equals(e)) {
          System.out.println(en);
          trouve = true;
        }
      }

      assertTrue(trouve);

    }

    @Test
    public void test_contientEntite() {
      Entite e = new Entite("entite 1", new Monde("monde1")){};
      Entite[] tabE = new Entite[0];

      assertFalse(Utilitaire.contientEntite(e.getNom(), tabE));

      tabE = Utilitaire.ajouterEntite(e, tabE);

      assertTrue(Utilitaire.contientEntite(e.getNom(), tabE));
    }

}
