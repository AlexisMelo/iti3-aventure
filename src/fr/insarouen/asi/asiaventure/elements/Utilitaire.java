package fr.insarouen.asi.asiaventure.elements;

import fr.insarouen.asi.asiaventure.elements.Entite;

public class Utilitaire{

  public static Entite[] ajouterEntite(Entite e,Entite[] tabEntite){
    Entite[] tabEntite2 = new Entite[tabEntite.length+1];
    for (int i = 0; i< tabEntite.length; i++) {
      tabEntite2[i] = tabEntite[i];
    }
    tabEntite2[tabEntite.length] = e;
    return tabEntite2;
  }

  public static boolean contientEntite(String nomEntite,Entite[] tabEntite){
    for(Entite e : tabEntite){
      if (e.getNom().equals(nomEntite)){
        return true;
      }
    }
    return false;
  }

  public static Entite[] retirerEntite(String e,Entite[] tabEntite){
    int j = 0;

    Entite[] tabEntite2 = new Entite[tabEntite.length-1];
    for (int i = 0; i< tabEntite.length; i++) {
      if (e!=tabEntite[i].getNom()){
        tabEntite2[j] = tabEntite[i];
        j++;
        }
    }
    return tabEntite2;
  }

  public static Entite obtenirEntite(String nomEntite,Entite[] tabEntite){
    for(Entite e : tabEntite){
      if (e.getNom().equals(nomEntite)){
        return e;
      }
    }
    return null;
  }

  public static String toStringTabEntite(Entite[] tabEntite){

    StringBuilder EntiteStr = new StringBuilder();
    for (int i = 0; i< tabEntite.length;i++){
      EntiteStr.append(tabEntite[i].getNom());
      EntiteStr.append(", ");
    }
    //EntiteStr.delete(EntiteStr.length()-2,EntiteStr.length());
    return EntiteStr.toString();
  }

  }
