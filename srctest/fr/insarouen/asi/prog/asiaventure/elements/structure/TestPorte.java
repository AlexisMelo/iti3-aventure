package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;

import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsNull;

public class TestPorte {

  private Porte porte;
  private Monde monde;
  public Piece piece1;
  public Piece piece2;
  public PiedDeBiche pdb;
  public Serrure serrure;
  public Serrure serrure2;
  public Clef clef;
  public Clef clef2;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException {
    this.monde = new Monde("Rouen");
    this.piece1 = new Piece("Piece n°1",this.monde);
    this.piece2 = new Piece("Piece n°2",this.monde);
    this.porte = new Porte("bernard", this.monde, this.piece1, this.piece2);
    this.pdb = new PiedDeBiche("Pdb",this.monde);
    this.serrure = new Serrure("serrure",this.monde);
    this.serrure2 = new Serrure("serrure2",this.monde);
    clef = this.serrure.creerClef();
    clef2 = this.serrure2.creerClef();
  }

  @Test
  public void test_constructeur() {
	assertThat(this.porte.getMonde(),is(this.monde));
	assertThat(this.porte.getNom(),is("bernard"));
	assertThat(this.porte.getPieceAutreCote(this.piece1),is(this.piece2));
	assertThat(this.porte.getPieceAutreCote(this.piece2),is(this.piece1));
	assertThat(this.porte.getEtat(), is(Etat.FERME));
  }

  @Test
  public void test_activableAvec() {
    assertThat(this.porte.activableAvec(pdb),is(true));
    assertThat(this.porte.activableAvec(clef),is(true));
  }

  @Test
  public void test_activer() throws ActivationImpossibleException {
	assertThat(this.porte.getEtat(), is(Etat.FERME));
	this.porte.activer();
	assertThat(this.porte.getEtat(), is(Etat.OUVERT));
  }

  @Test(expected=ActivationImpossibleException.class)
  public void test_activer_porte_verouillee() throws ActivationImpossibleException, ActivationImpossibleAvecObjetException {
    this.porte.activerAvec(pdb);
    this.porte.activer();
  }

  @Test
  public void test_activerAvec() throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
    this.porte.activerAvec(clef);
    assertThat(this.porte.getEtat(),is(Etat.OUVERT));
    this.porte.activerAvec(clef);
    assertThat(this.porte.getEtat(),is(Etat.VEROUILLE));
    this.porte.activerAvec(pdb);
    assertThat(this.porte.getEtat(),is(Etat.CASSE));

  }

  @Test(expected=ActivationImpossibleAvecObjetException.class)
  public void test_activerAvec_objet_invalide() throws ActivationImpossibleAvecObjetException, ActivationImpossibleException {
    this.porte.activerAvec(clef2);
  }

  @Test
  public void test_getEtat() {
	assertThat(this.porte.getEtat(), is(Etat.FERME));
  }

  @Test
  public void test_getSerrure() {
    assertThat(this.porte.getSerrure(), is(this.serrure));
  }

  @Test
  public void test_getPieceAutreCote() {
	assertThat(this.porte.getPieceAutreCote(this.piece1),is(this.piece2));
	assertThat(this.porte.getPieceAutreCote(this.piece2),is(this.piece1));
  }

  @Test
  public void test_getPieceAutreCote_nulle() throws NomDEntiteDejaUtiliseDansLeMondeException {
	Piece pAutre = new Piece("piece pas geree",this.monde);
	assertThat(this.porte.getPieceAutreCote(pAutre), IsNull.nullValue());
  }
}
