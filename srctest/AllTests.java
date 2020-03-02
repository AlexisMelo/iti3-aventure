import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.asiaventure.elements.AllTestElement;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AllTestElement.class
})
public class AllTests{}
