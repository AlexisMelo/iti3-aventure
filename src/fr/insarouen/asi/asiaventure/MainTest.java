package fr.insarouen.asi.asiaventure;

import fr.insarouen.asi.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.asiaventure.Monde;
import fr.insarouen.asi.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.asiaventure.elements.objets.PiedDeBiche;


public class MainTest {

  public static void main(String[] args) {

      Monde m1 = new Monde("Monde");
      Piece p1 = new Piece("Piece",m1);
      Objet[] o1 = new Objet[0];
      Vivant v1 = new Vivant("Didier",m1,10,20,p1,o1);

      PiedDeBiche pb = new PiedDeBiche("pied",m1);
      v1.prendre("pied");
      System.out.println(v1.toString());

    System.out.println(v1.toString());
      System.out.println("TESTS");
      System.out.println("getPiece : ");
      if (v1.getPiece().equals(p1)){
       System.out.println("ok");
      }
      else{
        System.out.println("ko");
      }

      System.out.println("getObjet : ");
      if (v1.getObjet("pied").equals(pb)){
       System.out.println("ok");
      }
      else{
        System.out.println("ko");
      }

      System.out.println("getObjets : ");
      if (v1.getObjets().equals(o1)){
       System.out.println("ok");
      }
      else{
        System.out.println("ko");
      }


      System.out.println("getPointForce : ");
      int f = 20;
      if (v1.getPointForce() == f){
       System.out.println("ok");
      }
      else{
        System.out.println("ko");
      }

      System.out.println("getPointVie : ");
      int v = 10;
      if (v1.getPointVie() == v){
       System.out.println("ok");
      }
      else{
        System.out.println("ko");
      }



  }
}
