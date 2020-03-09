package fr.insarouen.asi.prog.asiaventure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.AllTestElement;

@RunWith(Suite.class)
@SuiteClasses({
  AllTestElement.class,
  TestMonde.class
})
public class AllTestASIAventure{}
