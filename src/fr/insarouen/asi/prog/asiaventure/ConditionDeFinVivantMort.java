package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantMort extends ConditionDeFin{

  private EtatDuJeu etatConditionVerifiee;
  private Vivant vivant;

  public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee, Vivant vivant){
    super(etatConditionVerifiee);
    this.vivant = vivant;
  }

  public EtatDuJeu verifierCondition(){
    if (this.vivant.getPointVie().equals(0)) {
      return this.etatDuJeu;
  }
  else {
    return EtatDuJeu.ENCOURS; 
  }

}
