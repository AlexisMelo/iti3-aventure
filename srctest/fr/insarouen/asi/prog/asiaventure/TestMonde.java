package fr.insarouen.asi.prog.asiaventure;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

public class TestMonde {

  public Monde monde;
  public Entite entite;

  @Before
  public void init() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    this.monde = new Monde("INSA");
    this.entite = new Entite("Elève à l'INSA",this.monde){};
  }

  @Test
  public void test_getNom() {
    assertThat(this.monde.getNom(), IsEqual.equalTo("INSA"));
  }

  @Test
  public void test_getEntite_presente() {
    assertThat(this.monde.getEntite("Elève à l'INSA"), IsEqual.equalTo(this.entite));
  }

  @Test
  public void test_getEntite_non_trouvee() {
    assertThat(this.monde.getEntite("Elève à l'ESIGELEC"), IsNull.nullValue());
  }

  @Test(expected=EntiteDejaDansUnAutreMondeException.class)
  public void test_ajouter_exception_autre_monde() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    Entite entite2;
    Monde monde2;
    monde2 = new Monde("Université");
    entite2 = new Entite("Elève de Esitech",monde2){};

    this.monde.ajouter(entite2);
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void test_ajouter_exception_nom_utilise() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    new Entite("Elève à l'INSA",this.monde){};
  }
}
