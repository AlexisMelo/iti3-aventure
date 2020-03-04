package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;
import org.hamcrest.collection.IsArray;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

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
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException {
    if(this.printClassBeingTested) {
      System.out.println("Testing class Vivant");
      this.printClassBeingTested = false;
    }
    if(this.printObjectToString) {
      System.out.println(this.vivant);
      this.printObjectToString = false;
    }

      this.monde = new Monde("Rouen");
      this.piece =  new Piece("Piece n°1",this.monde);
      this.vivant = new Vivant("Mec",this.monde, 10, 10, this.piece, new Objet[0]);
  }

  @Test
  public void test_deposer() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetNonPossedeParLeVivantException {
    Objet obj1 = new Objet("objet 1",this.monde){
      public boolean estDeplacable() {
        return true;
      }
    };

    Objet tabObj[] = {obj1};

    Vivant vivant2 =  new Vivant("Mec 2", this.monde, 10, 10, this.piece, tabObj);

    assertThat(vivant2.possede(obj1), is(true));
    assertThat(this.piece.contientObjet(obj1), is(false));

    vivant2.deposer(obj1);

    assertThat(vivant2.possede(obj1), is(false));
    assertThat(this.piece.contientObjet(obj1), is(true));
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void test_deposer_exception_possede_avec_string() throws ObjetNonPossedeParLeVivantException{
    this.vivant.deposer("objet qui existe pas");
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void test_deposer_exception_possede_avec_obj() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetNonPossedeParLeVivantException{
    Objet obj1 = new Objet("objet qui existe pas",this.monde){
      public boolean estDeplacable() {
        return true;
      }
    };
    this.vivant.deposer(obj1);
  }

  @Test
  public void test_estMort() throws NomDEntiteDejaUtiliseDansLeMondeException{
    Vivant vivant3 = new Vivant("Meuf", this.monde, 0, 10, this.piece, new Objet[0]);

    assertThat(vivant3.estMort(), is(true));
  }

  @Test
  public void test_getObjet() throws NomDEntiteDejaUtiliseDansLeMondeException{
    Vivant vivant3 = null;
    Objet obj1 = new Objet("objet recherche",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
    Objet tabObj[] = {obj1};

    vivant3 = new Vivant("Meuf", this.monde, 0, 10, this.piece, tabObj);

    assertThat(obj1, IsEqual.equalTo(vivant3.getObjet("objet recherche")));
  }

  @Test
  public void test_getPiece(){
    assertThat(this.vivant.getPiece(), IsEqual.equalTo(this.piece));
  }


  @Test
  public void test_getPointForce(){
    assertThat(this.vivant.getPointForce(), IsEqual.equalTo(10));
  }

  @Test
  public void test_getPointVie(){
    assertThat(this.vivant.getPointVie(), IsEqual.equalTo(10));
  }

  @Test
  public void test_possede() throws NomDEntiteDejaUtiliseDansLeMondeException {
    Objet obj1 = null;
    Vivant vivant2 = null;


      obj1 = new Objet("objet 1",this.monde){
        public boolean estDeplacable() {
          return true;
          }
    };

    Objet tabObj[] = {obj1};

    vivant2 = new Vivant("Mec 2", this.monde, 10, 10, this.piece, tabObj);

    assertThat(vivant2.possede(obj1), is(true));
  }

  @Test
  public void test_prendre() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException, NomDEntiteDejaUtiliseDansLeMondeException{
    Objet obj1 = null;

      obj1 = new Objet("objet a prendre",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
      this.piece.deposer(obj1);

    assertThat(this.piece.contientObjet(obj1), is(true));
    assertThat(this.piece, IsEqual.equalTo(this.vivant.getPiece()));
    assertThat(this.vivant.possede(obj1), is(false));

    this.vivant.prendre(obj1);

    assertThat(this.vivant.possede(obj1), is(true));
    assertThat(this.piece.contientObjet(obj1), is(false));

  }
}
