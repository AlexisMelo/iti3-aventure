package fr.insarouen.asi.asiaventure.elements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.asiaventure.elements.objets.AllTestObjets;
import fr.insarouen.asi.asiaventure.elements.vivants.AllTestVivant;
import fr.insarouen.asi.asiaventure.elements.structure.AllTestStructure;

@RunWith(Suite.class)
@SuiteClasses({
  TestEntite.class,
  TestUtilitaire.class,
  AllTestObjets.class,
  AllTestVivant.class,
  AllTestStructure.class
})
public class AllTestElement{}
