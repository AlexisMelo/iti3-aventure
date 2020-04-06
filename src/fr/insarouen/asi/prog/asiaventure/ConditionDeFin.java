package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;

public  abstract class ConditionDeFin implements Serializable {

private EtatDuJeu etatDuJeu;

  public ConditionDeFin(EtatDuJeu etatDuJeu){
    this.etatDuJeu = etatDuJeu;
  }

  public EtatDuJeu getEtatConditionVerifiee(){
    return this.etatDuJeu; 
  }

  public abstract EtatDuJeu verifierCondition();

}
