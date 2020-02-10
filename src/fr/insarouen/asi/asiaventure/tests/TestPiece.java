package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.elements.vivants.Vivant;


public class TestPiece {

    public Monde monde;
    public Piece piece;

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
        System.out.println("Testing class Piece");
        this.printClassBeingTested = false;
      }
      if(this.printObjectToString) {
        System.out.println(this.piece);
        this.printObjectToString = false;
      }

      try {
        this.monde = new Monde("Rouen");
        this.piece = new Piece("Piece n°1",this.monde);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    @Test
    public void test_addPorte() {
      Porte p = null;

      try {
        p = new Porte("porte 1 ",this.monde);
        this.piece.addPorte(p);
      } catch (Exception e) {
        System.out.println(e);
      }

      assertTrue(this.piece.aLaPorte(p));
      assertTrue(this.piece.aLaPorte(p.getNom()));
    }

    @Test
    public void test_deposer() {
      Objet o = null;

      try {
        o = new Objet("obj 1",this.monde){
          public boolean estDeplacable() {
            return true;
          }
        };
        this.piece.deposer(o);
      } catch (Exception e) {
        System.out.println(e);
      }

      assertTrue(this.piece.contientObjet(o));
      assertTrue(this.piece.contientObjet(o.getNom()));

    }

    @Test
    public void test_retirer() {
      Objet o = null;

      try {
        o = new Objet("obj2", this.monde){
          public boolean estDeplacable() {
            return true;
          }
        };
        this.piece.deposer(o);
      } catch (Exception e) {
        System.out.println(e);
      }
      assertTrue(this.piece.contientObjet(o));
      try {
        this.piece.retirer(o);
      } catch (Exception e) {
        System.out.println(e);
      }
      assertFalse(this.piece.contientObjet(o));
    }

    @Test
    public void test_entrer_sortir() {
      Vivant v = null;

      try {
        v =  new Vivant("Mec",this.monde, 10, 10, this.piece, new Objet[0]);
      } catch (Exception e) {
        System.out.println(e);
      }


      assertTrue(this.piece.contientVivant(v));
      assertTrue(this.piece.contientVivant(v.getNom()));

      try {
        this.piece.sortir(v);
      } catch (Exception e) {
        System.out.println(e);
      }

      assertFalse(this.piece.contientVivant(v));

      try {
        this.piece.entrer(v);
      } catch (Exception e) {
        System.out.println(e);
      }

      assertTrue(this.piece.contientVivant(v));
    }

    @Test
    public void test_getPorte() {
      Porte p = null;

      try {
        p = new Porte("superporte",this.monde);
      } catch (Exception e) {
        System.out.println(e);
      }

      assertNull(this.piece.getPorte("superporte"));

      try {
        this.piece.addPorte(p);
      } catch (Exception e) {
        System.out.println(e);
      }

      assertEquals(this.piece.getPorte("superporte"), p);

    }
}
