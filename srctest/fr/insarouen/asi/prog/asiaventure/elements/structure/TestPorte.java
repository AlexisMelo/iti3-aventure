package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import org.hamcrest.core.IsEqual;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsNull;

public class TestPorte {

  private Porte porte;
  private Monde monde;
  public Piece piece1;
  public Piece piece2;

  @Before
  public void init() {
    this.monde = new Monde("Rouen");
    this.piece1 = new Piece("Piece n°1",this.monde);
    this.piece2 = new Piece("Piece n°2",this.monde);
    this.porte = new Porte("bernard", this.monde, this.piece1, this.piece2);
  }

  @Test
  public test_constructeur() {
    //à faire, sans serrure pour l'instant
  }

  @Test
  public test_activableAvec() {
    //à faire
  }

  @Test
  public test_activer() {
    //à faire
  }

  @Test
  public test_activerAvec() {
    //à faire
  }

  @Test
  public test_getEtat() {
    //à faire
  }

  @Test
  public test_getSerrure() {
    //à faire
  }

  @Test
  public test_getPieceAutreCote() {
    //à faire
  }
}
