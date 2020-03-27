package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import org.junit.Test;
import org.junit.Before;


import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;


import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class TestClef{

private Monde monde;
private Clef clef;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.monde = new Monde("Rouen");
    this.clef = new Clef("clef",this.monde);
  }


  @Test
  public void test_constructeur(){
    assertThat(this.clef.getNom(),is("clef"));
    assertThat(this.clef.getMonde(),is(this.monde));
  }


  @Test
  public void test_estDeplacable(){
    assertThat(this.clef.estDeplacable(),is(true));
  }
}
