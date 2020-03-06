package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsNull;


import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;


public class TestPiece {

    public Monde monde;
    public Piece piece;

    @Before
    public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
      this.monde = new Monde("Rouen");
      this.piece = new Piece("Piece n°1",this.monde);
    }

    @Test
    public void test_addPorte_et_aLaPorte() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Porte p = new Porte("porte 1",this.monde);

      assertThat(this.piece.aLaPorte(p), is(false));
      assertThat(this.piece.aLaPorte(p.getNom()), is(false));

      this.piece.addPorte(p);

      assertThat(this.piece.aLaPorte(p), is(true));
      assertThat(this.piece.aLaPorte(p.getNom()), is(true));
    }

    @Test
    public void test_deposer_et_contientObjet() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Objet o = new Objet("obj 1",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };

      assertThat(this.piece.contientObjet(o), is(false));
      assertThat(this.piece.contientObjet(o.getNom()), is(false));

      this.piece.deposer(o);

      assertThat(this.piece.contientObjet(o), is(true));
      assertThat(this.piece.contientObjet(o.getNom()), is(true));

    }

    @Test
    public void test_deposer_retirer() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
      Objet o = new Objet("obj2", this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };

      this.piece.deposer(o);

      assertThat(this.piece.contientObjet(o), is(true));

      this.piece.retirer(o);

      assertThat(this.piece.contientObjet(o), is(false));
    }

    @Test
    public void test_entrer_sortir_contientVivant() throws NomDEntiteDejaUtiliseDansLeMondeException, VivantAbsentDeLaPieceException {
      Vivant v = new Vivant("Mec",this.monde, 10, 10, this.piece, new Objet[0]);

      assertThat(this.piece.contientVivant(v), is(true));
      assertThat(this.piece.contientVivant(v.getNom()), is(true));

      this.piece.sortir(v);

      assertThat(this.piece.contientVivant(v), is(false));
      assertThat(this.piece.contientVivant(v.getNom()), is(false));

      this.piece.entrer(v);

      assertThat(this.piece.contientVivant(v), is(true));
      assertThat(this.piece.contientVivant(v.getNom()), is(true));

    }

    @Test
    public void test_getPorte() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Porte p = new Porte("superporte",this.monde);

      assertThat(this.piece.getPorte("superporte"), IsNull.nullValue());

      this.piece.addPorte(p);

      assertThat(this.piece.getPorte("superporte"), IsEqual.equalTo(p));

    }
}
