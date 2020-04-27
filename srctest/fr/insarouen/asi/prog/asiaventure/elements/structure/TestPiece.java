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
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Monstre;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;


public class TestPiece {

    public Monde monde;
    public Piece piece1;
    public Piece piece2;
    public Objet[] objets;
    public Monstre Monstre;

    @Before
    public void init() throws NomDEntiteDejaUtiliseDansLeMondeException{
      this.monde = new Monde("Rouen");
      this.piece1 = new Piece("Piece n°1",this.monde);
      this.piece2 = new Piece("Piece n°2",this.monde);
    }

    @Test
    public void test_constructeur(){
      assertThat(this.piece1.getMonde(),is(this.monde));
      assertThat(this.piece1.getNom(),is("Piece n°1"));
    }

    @Test
    public void test_addPorte_et_aLaPorte() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Porte p = new Porte("porte 1",this.monde, this.piece1, this.piece2);

      assertThat(this.piece1.aLaPorte(p), is(true));
      assertThat(this.piece1.aLaPorte(p.getNom()), is(true));
    }

    @Test
    public void test_deposer_et_contientObjet() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Objet o = new Objet("obj 1",this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };

      assertThat(this.piece1.contientObjet(o), is(false));
      assertThat(this.piece1.contientObjet(o.getNom()), is(false));

      this.piece1.deposer(o);

      assertThat(this.piece1.contientObjet(o), is(true));
      assertThat(this.piece1.contientObjet(o.getNom()), is(true));

    }

    @Test
    public void test_deposer_retirer() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
      Objet o = new Objet("obj2", this.monde){
        public boolean estDeplacable() {
          return true;
        }
      };

      this.piece1.deposer(o);

      assertThat(this.piece1.contientObjet(o), is(true));

      this.piece1.retirer(o);

      assertThat(this.piece1.contientObjet(o), is(false));
    }

    @Test
    public void test_entrer_sortir_contientVivant() throws NomDEntiteDejaUtiliseDansLeMondeException, VivantAbsentDeLaPieceException {
      Monstre v = new Monstre("Mec",this.monde, 10, 10, this.piece1, new Objet[0]);

      assertThat(this.piece1.contientVivant(v), is(true));
      assertThat(this.piece1.contientVivant(v.getNom()), is(true));

      this.piece1.sortir(v);

      assertThat(this.piece1.contientVivant(v), is(false));
      assertThat(this.piece1.contientVivant(v.getNom()), is(false));

      this.piece1.entrer(v);

      assertThat(this.piece1.contientVivant(v), is(true));
      assertThat(this.piece1.contientVivant(v.getNom()), is(true));

    }

    @Test(expected=ObjetAbsentDeLaPieceException.class)
    public void test_retirer_exception_objetAbsentPiece() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{
      Objet obj1 = new Objet("objet a prendre",this.monde){
          public boolean estDeplacable() {
            return true;
          }
        };

          this.piece1.retirer(obj1);
    }


    @Test(expected=ObjetNonDeplacableException.class)
    public void test_retirer_exception_objetNonDeplacable() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{
      Objet obj1 = new Objet("objet a prendre",this.monde){
          public boolean estDeplacable() {
            return false;
          }
        };
      this.piece1.deposer(obj1);

      this.piece1.retirer(obj1);
    }

    @Test(expected=VivantAbsentDeLaPieceException.class)
    public void test_sortir_exception_VivantAbsent() throws NomDEntiteDejaUtiliseDansLeMondeException,VivantAbsentDeLaPieceException,NomDEntiteDejaUtiliseDansLeMondeException{

      this.piece1.sortir("vivant absent");
    }

    @Test
    public void test_getPorte() throws NomDEntiteDejaUtiliseDansLeMondeException{
      Porte p = new Porte("superporte",this.monde, this.piece1, this.piece2);

      assertThat(this.piece1.getPorte("superporte"), IsEqual.equalTo(p));

    }
}
