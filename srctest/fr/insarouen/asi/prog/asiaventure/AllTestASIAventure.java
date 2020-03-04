package fr.insarouen.asi.asiaventure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.asiaventure.elements.AllTestElement;

@RunWith(Suite.class)
@SuiteClasses({
  AllTestElement.class,
  TestMonde.class
})
public class AllTestASIAventure{}
