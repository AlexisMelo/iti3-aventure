package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import org.junit.Test;
import org.junit.Before;


import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;


import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import org.hamcrest.core.IsNull;


public class TestSerrure{


  public Etat etat;
  public Monde monde;
  public Serrure serrure;
  public Serrure serrure2;
  public Clef clef;
  public Clef clef2;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.monde = new Monde("Rouen");
    this.serrure = new Serrure("serrure 1 ", this.monde);
    this.serrure2 = new Serrure(this.monde);
	this.clef = this.serrure.creerClef();
    this.clef2 = this.serrure2.creerClef();
  }

  @Test
  public void test_constructeur(){
    assertThat(this.serrure.getEtat(),is(Etat.VEROUILLE));
    assertThat(this.serrure.getNom(), is("serrure 1 "));
  }

  @Test
  public void test_creerClef(){
    assertThat(this.clef.getNom(),is("clef 0 pour ouvrir : serrure 1 "));
    assertThat(this.serrure.creerClef(),IsNull.nullValue());
  }


  @Test
  public void Test_activableAvec(){
    assertThat(this.serrure.activableAvec(this.clef), is(true));
    assertThat(this.serrure.activableAvec(this.clef2), is(false));

  }

  @Test
  public void test_activerAvec() throws ActivationImpossibleAvecObjetException{
    this.serrure.activerAvec(this.clef);
    assertThat(this.serrure.getEtat(),is(Etat.DEVEROUILLE));
    this.serrure.activerAvec(this.clef);
    assertThat(this.serrure.getEtat(),is(Etat.VEROUILLE));
  }

  @Test(expected = ActivationImpossibleAvecObjetException.class)
  public void test_activerAvec_ActivationImpossibleAvecObjetException() throws ActivationImpossibleAvecObjetException{
    this.serrure.activerAvec(clef2);
  }
}
