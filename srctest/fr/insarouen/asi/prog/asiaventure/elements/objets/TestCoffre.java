package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.Test;
import org.junit.Before;


import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Coffre;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class TestCoffre {

  private Coffre coffre;
  private Monde monde;
  private PiedDeBiche obj;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.monde = new Monde("Rouen");
    this.obj = new PiedDeBiche("Objet",this.monde);
    this.coffre = new Coffre("Nom du coffre",this.monde);
  }

  @Test
  public void Test_activer(){
    assertThat(this.coffre.getEtat(),is(Etat.FERME));
    this.coffre.activer();
    assertThat(this.coffre.getEtat(),is(Etat.OUVERT));
    }

  @Test(expected=ActivationException.class)
  public void Test_activerAvec_ActivationException() throws ActivationException{
    this.coffre.activerAvec(this.obj);
  }

  @Test
  public void Test_activableAvec(){
    assertThat(this.coffre.activableAvec(this.obj),is(false));
  }
}
