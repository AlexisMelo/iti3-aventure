package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestObjet {

    public Monde monde;
    public Objet obj;

    @Before
    public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
      this.monde = new Monde("Rouen");
      this.obj = new Objet("Objet n°1",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };
    }

    @Test
    public void test_estDeplacable() {
      //test inutile mais j'ai pas compris le sujet de TP qui dit de refaire nos tests
      assertThat(this.obj.estDeplacable(),is(true));
    }

}
