package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;



import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

      try {
        Monde m1 = new Monde("Monde");
        Piece p1 = new Piece("Piece",m1);
        Objet[] o1 = new Objet[0];
        Vivant v1 = new Vivant("Didier",m1,10,20,p1,o1);
        PiedDeBiche pb = new PiedDeBiche("pied",m1);


        p1.deposer(pb);
        System.out.println("la piece : "+p1);

        try {
          v1.prendre("pied");
        } catch (ObjetAbsentDeLaPieceException | ObjetNonDeplacableException o) {
          System.out.println(o);
        }

        System.out.println(v1);

        System.out.println("TESTS");
        System.out.println("getPiece : ");

        if (v1.getPiece().equals(p1)){
         System.out.println("ok");
        }
        else {
          System.out.println("ko");
        }

        System.out.println("getObjet : ");
        if (pb.equals(v1.getObjet("pied"))){
         System.out.println("ok");
        }
        else{
          System.out.println("ko");
        }

        System.out.println("getObjets : ");
        if ( Arrays.equals( v1.getObjets(), new Objet[]{pb} ) )
        {
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
    } catch (NomDEntiteDejaUtiliseDansLeMondeException e){
      System.out.println(e);
    }
  }
}
