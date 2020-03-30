package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsNull;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Monstre;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;

import java.util.Map;
import java.util.HashMap;

public class TestVivant{

  public Monde monde;
  public Piece piece;
  public Monstre Monstre;
  public Map<String,Objet> objs;


  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException {
    objs = new HashMap<>();
    this.monde = new Monde("Rouen");
    this.piece =  new Piece("Piece n°1",this.monde);
    this.Monstre = new Monstre("Mec",this.monde, 10, 10, this.piece, new Objet[0]);
  }

  @Test
  public void test_constructeur(){
    assertThat(this.Monstre.getMonde(),is(this.monde));
    assertThat(this.Monstre.getNom(),is("Mec"));
    assertThat(this.Monstre.getPiece(),is(this.piece));
    assertThat(this.Monstre.getPointForce(),is(10));
    assertThat(this.Monstre.getPointVie(),is(10));
    assertThat(this.Monstre.getObjets(),is(objs));
  }


  @Test
  public void test_deposer() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetNonPossedeParLeVivantException {
    Objet obj1 = new Objet("objet 1",this.monde){
      public boolean estDeplacable() {
        return true;
      }
    };

    Objet tabObj[] = {obj1};

    Monstre Monstre2 =  new Monstre("Mec 2", this.monde, 10, 10, this.piece, tabObj);

    assertThat(Monstre2.possede(obj1), is(true));
    assertThat(this.piece.contientObjet(obj1), is(false));

    Monstre2.deposer(obj1);

    assertThat(Monstre2.possede(obj1), is(false));
    assertThat(this.piece.contientObjet(obj1), is(true));
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void test_deposer_exception_possede_avec_string() throws ObjetNonPossedeParLeVivantException{
    this.Monstre.deposer("objet qui existe pas");
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void test_deposer_exception_possede_avec_obj() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetNonPossedeParLeVivantException{
    Objet obj1 = new Objet("objet qui existe pas",this.monde){
      public boolean estDeplacable() {
        return true;
      }
    };
    this.Monstre.deposer(obj1);
  }

  @Test
  public void test_estMort() throws NomDEntiteDejaUtiliseDansLeMondeException{

    assertThat(this.Monstre.estMort(), is(false));

    Monstre Monstre3 = new Monstre("Meuf", this.monde, 0, 10, this.piece, new Objet[0]);

    assertThat(Monstre3.estMort(), is(true));
  }

  @Test
  public void test_getObjet() throws NomDEntiteDejaUtiliseDansLeMondeException{

    Objet obj1 = new Objet("objet recherche",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
    Objet tabObj[] = {obj1};

    Monstre Monstre3 = new Monstre("Meuf", this.monde, 0, 10, this.piece, tabObj);

    assertThat(obj1, IsEqual.equalTo(Monstre3.getObjet("objet recherche")));
  }

  @Test
  public void test_getObjet_returns_null() throws NomDEntiteDejaUtiliseDansLeMondeException {
    assertThat(this.Monstre.getObjet("objet non possede"), IsNull.nullValue());
  }

  @Test
  public void test_getPiece(){
    assertThat(this.Monstre.getPiece(), IsEqual.equalTo(this.piece));
  }


  @Test
  public void test_getPointForce(){
    assertThat(this.Monstre.getPointForce(), IsEqual.equalTo(10));
  }

  @Test
  public void test_getPointVie(){
    assertThat(this.Monstre.getPointVie(), IsEqual.equalTo(10));
  }

  @Test
  public void test_possede() throws NomDEntiteDejaUtiliseDansLeMondeException {
    Objet obj1 = new Objet("objet 1",this.monde){
      public boolean estDeplacable() {
        return true;
        }
    };
    Objet tabObj[] = {obj1};
    Monstre Monstre2 = new Monstre("Mec 2", this.monde, 10, 10, this.piece, tabObj);

    assertThat(Monstre2.possede(obj1), is(true));
  }

  @Test
  public void test_prendre() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException, NomDEntiteDejaUtiliseDansLeMondeException{
    Objet obj1 = new Objet("objet a prendre",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
    this.piece.deposer(obj1);

    assertThat(this.piece.contientObjet(obj1), is(true));
    assertThat(this.piece, IsEqual.equalTo(this.Monstre.getPiece()));
    assertThat(this.Monstre.possede(obj1), is(false));

    this.Monstre.prendre(obj1);

    assertThat(this.Monstre.possede(obj1), is(true));
    assertThat(this.piece.contientObjet(obj1), is(false));

  }

  @Test(expected=ObjetNonDeplacableException.class)
  public void test_prendre_exception_objetNonDeplacable() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{
    Objet obj1 = new Objet("objet a prendre",this.monde){
      public boolean estDeplacable() {
        return false;
      }
    };

    this.piece.deposer(obj1);

    assertThat(this.piece.contientObjet(obj1), is(true));
    assertThat(this.piece, IsEqual.equalTo(this.Monstre.getPiece()));
    assertThat(this.Monstre.possede(obj1), is(false));

    this.Monstre.prendre(obj1);
  }

  @Test(expected=ObjetAbsentDeLaPieceException.class)
  public void test_prendre_exception_objetAbsentPiece() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{
    Objet obj1 = new Objet("objet a prendre",this.monde){
      public boolean estDeplacable() {
        return true;
      }
    };

    this.Monstre.prendre(obj1);
  }

  @Test
  public void test_franchir_normal() throws NomDEntiteDejaUtiliseDansLeMondeException, PorteInexistanteDansLaPieceException, PorteFermeException, ActivationImpossibleException {
    Piece piece2 = new Piece("piece o� atterir",this.monde);
    Porte porteAFranchir = new Porte("porte � franchir", this.monde, this.piece, piece2);
    this.piece.addPorte(porteAFranchir);

    assertThat(this.Monstre.getPiece(), is(this.piece));
    assertThat(porteAFranchir.getEtat(), is(Etat.FERME));

    porteAFranchir.activer();

    assertThat(porteAFranchir.getEtat(), is(Etat.OUVERT));

    this.Monstre.franchir(porteAFranchir);
    assertThat(this.Monstre.getPiece(), is(piece2));

  }

  @Test(expected=PorteFermeException.class)
  public void test_franchir_porte_fermee() throws NomDEntiteDejaUtiliseDansLeMondeException, PorteInexistanteDansLaPieceException, PorteFermeException {
    Piece piece2 = new Piece("piece o� atterir",this.monde);
    Porte porteAFranchir = new Porte("porte � franchir", this.monde, this.piece, piece2);
    this.piece.addPorte(porteAFranchir);

    assertThat(this.Monstre.getPiece(), is(this.piece));
    assertThat(porteAFranchir.getEtat(), is(Etat.FERME));

    this.Monstre.franchir(porteAFranchir);
  }

  @Test(expected=PorteInexistanteDansLaPieceException.class)
  public void test_franchir_porte_pas_dans_la_piece() throws PorteInexistanteDansLaPieceException, PorteFermeException, NomDEntiteDejaUtiliseDansLeMondeException {
	Piece piece2 = new Piece("piece o� atterir",this.monde);
	Porte porteAFranchir = new Porte("porte � franchir", this.monde, this.piece, piece2);

	this.Monstre.franchir(porteAFranchir);
  }

  @Test
  public void test_activerActivable_normal() throws NomDEntiteDejaUtiliseDansLeMondeException, ActivationImpossibleException {
	Piece piece2 = new Piece("piece o� atterir",this.monde);
	Porte porteAFranchir = new Porte("porte � franchir", this.monde, this.piece, piece2);
	this.piece.addPorte(porteAFranchir);

	assertThat(porteAFranchir.getEtat(), is(Etat.FERME));

    porteAFranchir.activer();

    assertThat(porteAFranchir.getEtat(), is(Etat.OUVERT));
  }

  //@Test(expected=ActivationException.class)
  public void test_activerActivable_Activation_exception() {
    //à faire
  }

  //@Test
  public void test_activerActivable_avec_objet_normal() {
    //à faire
  }

  //@Test(expected=ActivationException.class)
  public void test_activerActivable_avec_objet_Activation_exception() {
    //à faire
  }

}
