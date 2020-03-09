import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.AllTestASIAventure;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AllTestASIAventure.class
})
public class AllTests{}
