package fr.insarouen.asi.asiaventure.tests;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.Entite;
import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.asiaventure.elements.structure.Piece;



public class TestVivant{

  public Monde monde;
  public Piece piece;
  public Vivant vivant;

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
      System.out.println("Testing class Vivant");
      this.printClassBeingTested = false;
    }
    if(this.printObjectToString) {
      System.out.println(this.vivant);
      this.printObjectToString = false;
    }

    try {
      this.monde = new Monde("Rouen");
      this.piece =  new Piece("Piece n°1",this.monde);
      this.vivant = new Vivant("Mec",this.monde, 10, 10, this.piece, new Objet[0]);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void test_deposer() {
    Objet obj1 = null;
    Vivant vivant2 = null;

    try {
      obj1 = new Objet("objet 1",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
    } catch (Exception e) {
      System.out.println(e);
    }

    Objet tabObj[] = {obj1};

    try {
      vivant2 = new Vivant("Mec 2", this.monde, 10, 10, this.piece, tabObj);
    } catch (Exception e) {
      System.out.println(e);
    }
    assertTrue(vivant2.possede(obj1));
    assertFalse(this.piece.contientObjet(obj1));

    try {
      vivant2.deposer(obj1);
    } catch (Exception e) {
      System.out.println(e);
    }


    assertFalse(vivant2.possede(obj1));
    assertTrue(this.piece.contientObjet(obj1));
  }

  @Test
  public void test_estMort() {
    Vivant vivant3 = null;
    try {
      vivant3 = new Vivant("Meuf", this.monde, 0, 10, this.piece, new Objet[0]);
    } catch (Exception e) {
      System.out.println(e);
    }
    assertTrue(vivant3.estMort());
  }

  @Test
  public void test_getObjet() {
    Vivant vivant3 = null;
    Objet obj1 = null;

    try {
      obj1 = new Objet("objet recherche",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };

    } catch (Exception e) {
      System.out.println(e);
    }

    Objet tabObj[] = {obj1};

    try {
      vivant3 = new Vivant("Meuf", this.monde, 0, 10, this.piece, tabObj);
    } catch (Exception e) {
      System.out.println(e);
    }
    assertEquals(obj1, vivant3.getObjet("objet recherche"));
  }

  @Test
  public void test_prendre() {
    Objet obj1 = null;

    try {
      obj1 = new Objet("objet a prendre",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
      this.piece.deposer(obj1);

    } catch (Exception e) {
      System.out.println(e);
    }


    assertTrue(this.piece.contientObjet(obj1));
    assertEquals(this.piece, this.vivant.getPiece());
    assertFalse(this.vivant.possede(obj1));

    try {
      this.vivant.prendre(obj1);
    } catch (Exception e) {
      System.out.println(e);
    }

    assertTrue(this.vivant.possede(obj1));
    assertFalse(this.piece.contientObjet(obj1));

  }
}
