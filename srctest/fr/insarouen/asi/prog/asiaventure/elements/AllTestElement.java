package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.objets.AllTestObjets;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.AllTestVivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.AllTestStructure;

@RunWith(Suite.class)
@SuiteClasses({
  TestEntite.class,
  AllTestObjets.class,
  AllTestVivant.class,
  AllTestStructure.class
})
public class AllTestElement{}
