package fr.insarouen.asi.asiaventure.tests;

import fr.insarouen.asi.asiaventure.tests.TestEntite;
import fr.insarouen.asi.asiaventure.tests.TestObjet;
import fr.insarouen.asi.asiaventure.tests.TestPiece;
import fr.insarouen.asi.asiaventure.tests.TestVivant;
import fr.insarouen.asi.asiaventure.tests.TestUtilitaire;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

   public static void testerClasse(Class o) {
     System.out.printf("\n");

     Result result = JUnitCore.runClasses(o);

     System.out.printf("Test ran: %s, Failed: %s (%s %%) %n",
                   result.getRunCount(),
                   result.getFailureCount(),
                   100 - result.getFailureCount() * 100 / result.getRunCount()
                   );

     for (Failure failure : result.getFailures()) {
        System.out.println("\n"+failure.toString());
     }
   }

   public static void main(String[] args) {

     testerClasse(TestEntite.class);
     testerClasse(TestPiece.class);
     testerClasse(TestUtilitaire.class);
     testerClasse(TestObjet.class);
     testerClasse(TestVivant.class);


   }
}
