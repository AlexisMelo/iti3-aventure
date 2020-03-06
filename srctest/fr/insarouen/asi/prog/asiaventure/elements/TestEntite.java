package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestEntite{

  public Monde monde;
  public Entite entite;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.monde = new Monde("Rouen");
    this.entite = new Entite("Elève à l'INSA",this.monde){};
  }

  @Test
  public void test_getNom() {
    assertThat(this.entite.getNom(), IsEqual.equalTo("Elève à l'INSA"));
  }

  @Test
  public void test_getMonde() {
    assertThat(this.entite.getMonde(), IsEqual.equalTo(this.monde));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void test_constructeurException() throws NomDEntiteDejaUtiliseDansLeMondeException{
    new Entite("Elève à l'INSA", this.monde){};
  }


}
