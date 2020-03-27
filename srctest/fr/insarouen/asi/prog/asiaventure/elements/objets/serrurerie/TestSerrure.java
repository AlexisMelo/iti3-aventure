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
  public Clef clef1;
  public Clef clef2;


  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
    this.monde = new Monde("Rouen");
    this.serrure = new Serrure(this.monde);
    this.serrure2 = new Serrure(this.monde);
    clef1 = this.serrure.creerClef();
    clef2 = this.serrure2.creerClef();
  }

  @Test
  public void test_constructeur(){
    assertThat(this.serrure.getEtat(),is(Etat.VEROUILLE));
    assertThat(this.serrure.getNom(), is("serrure 0"));
    assertThat(this.serrure2.getNom(), is("serrure 1"));
  }

  @Test
  public void test_creerClef(){
    assertThat(clef1.getNom(),is("clef 0 pour ouvrir : serrure 0"));
    assertThat(this.serrure.creerClef(),IsNull.nullValue());
    assertThat(clef2.getNom(), is("clef 1 pour ouvrir : serrure 1"));
  }


  @Test
  public void Test_activableAvec(){
    assertThat(this.serrure.activableAvec(clef1), is(true));
    assertThat(this.serrure.activableAvec(clef2), is(false));
  }

  @Test
  public void test_activerAvec() throws ActivationImpossibleAvecObjetException{
    this.serrure.activerAvec(clef1);
    assertThat(this.serrure.getEtat(),is(Etat.DEVEROUILLE));
    this.serrure.activerAvec(clef1);
    assertThat(this.serrure.getEtat(),is(Etat.VEROUILLE));
  }

  @Test(expected = ActivationImpossibleAvecObjetException.class)
  public void test_activerAvec_ActivationImpossibleAvecObjetException() throws ActivationImpossibleAvecObjetException{
    this.serrure.activerAvec(clef2);
  }
}
