package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.AllTestSerrurerie;


@RunWith(Suite.class)
@SuiteClasses({
  TestObjet.class,
  TestPiedDeBiche.class,
  TestCoffre.class,
  AllTestSerrurerie.class
})
public class AllTestObjets{}
