package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import java.util.Map;


public class Utilitaire{


  public static String toStringTabEntite(Map<String,? extends Entite> tabEntite){

    StringBuilder EntiteStr = new StringBuilder();
    for (String str : tabEntite.keySet()) {
      EntiteStr.append(str);
      EntiteStr.append(" , ");
    }
    //EntiteStr.delete(EntiteStr.length()-2,EntiteStr.length());
    return EntiteStr.toString();
  }

  }
