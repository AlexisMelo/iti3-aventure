package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.elements.Utilitaire;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestUtilitaire {

    @Test
    public void test_ajoutEntite() throws NomDEntiteDejaUtiliseDansLeMondeException {
      Entite ent = null;

      ent = new Entite("entite 1", new Monde("monde1")){};

      Entite[] tabE = new Entite[0];

      assertThat(0, IsEqual.equalTo(tabE.length));
      tabE = Utilitaire.ajouterEntite(ent, tabE);

      assertThat(1, IsEqual.equalTo(tabE.length));

      boolean trouve = false;

      for (Entite en : tabE) {
        if (en.equals(ent)) {
          trouve = true;
        }
      }

      assertThat(trouve, is(true));

    }

    @Test
    public void test_contientEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Entite ent = null;

      ent = new Entite("entite 1", new Monde("monde1")){};

      Entite[] tabE = new Entite[0];

      assertThat(Utilitaire.contientEntite(ent.getNom(), tabE), is(false));

      tabE = Utilitaire.ajouterEntite(ent, tabE);

      assertThat(Utilitaire.contientEntite(ent.getNom(), tabE), is(true));
    }
}
