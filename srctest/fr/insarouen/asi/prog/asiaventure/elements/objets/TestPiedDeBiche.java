package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.Monde;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


public class TestPiedDeBiche {
  public Monde monde;
  public PiedDeBiche pdb;
  public PiedDeBiche pdb2;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.monde = new Monde("Rouen");
    this.pdb = new PiedDeBiche("Pied de biche",this.monde);
  }

  @Test
  public void test_constructeur() throws NomDEntiteDejaUtiliseDansLeMondeException {
    assertThat(this.pdb.getMonde(),is(monde));
    assertThat(this.pdb.getNom(),is("Pied de biche"));
    assertThat(this.pdb.estDeplacable(),is(true));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void test_constructeur_exception() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.pdb2 = new PiedDeBiche("Pied de biche",this.monde);
  }
}
