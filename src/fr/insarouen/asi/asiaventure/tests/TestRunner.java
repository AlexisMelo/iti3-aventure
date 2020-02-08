package fr.insarouen.asi.asiaventure.tests;

import fr.insarouen.asi.asiaventure.tests.TestEntite;
import fr.insarouen.asi.asiaventure.tests.TestObjet;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {

      Result result = JUnitCore.runClasses(TestEntite.class, TestObjet.class);

      System.out.printf("Test ran: %s, Failed: %s (%s %%) %n",
                    result.getRunCount(),
                    result.getFailureCount(),
                    result.getFailureCount() * 100 / result.getRunCount()
                    );

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println(result.wasSuccessful());
   }
}
